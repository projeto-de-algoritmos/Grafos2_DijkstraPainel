package trabalho;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {
	public static void main(String args[]) {

		Graph graph = new Graph();
		;
		Node source = null;

		while (true) {

			int option = JOptionPane.showConfirmDialog(null, "Deseja adicionar uma aresta?");

			if (option == JOptionPane.YES_OPTION) {
				String nodeA = JOptionPane.showInputDialog("Digite o nome do primeiro nó:");
				Node a = new Node(nodeA);
				graph.addNode(a);
				if (graph.getNodes().size() == 1) {
					source = a;
					System.out.print(source);
				}
				String nodeB = JOptionPane.showInputDialog("Digite o nome do segundo nó:");
				Node b = new Node(nodeB);
				graph.addNode(b);
				String input = JOptionPane.showInputDialog("Digite a distancia entre os nós:");
				try {
					int value = Integer.parseInt(input);
					a.addEdge(b, value);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Valor inválido", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				if (option == JOptionPane.NO_OPTION) {
					break;
				}
			}
		}

		int option = JOptionPane.showConfirmDialog(null, "Deseja ver as menores distâncias?");

		if (option == JOptionPane.YES_OPTION) {
			graph = Dijkstra.calculateShortestPathFromSource(graph, source);
			graph.printShortestsPaths();
			JFrame frame = new JFrame("Menores distâncias");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			for (Node node : graph.getNodes()) {
				System.out.println();
				JLabel nomeName = new JLabel(" Nome: " + node.getName().toString());
				panel.add(nomeName);
				JLabel shortestPath = new JLabel(" Caminho mais curto: " + node.getShortestPath().toString());
				panel.add(shortestPath);
				JLabel distance = new JLabel(" Distância: " + node.getDistance().toString());
				panel.add(distance);
				panel.add(Box.createVerticalStrut(10));
			}

			frame.getContentPane().add(panel);

			frame.setSize(400, 1000);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "Finalizado.");
		}

	}
}
