package trabalho;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** Represents a graph like a set of nodes. */
public class Graph {

	private Set<Node> nodes = new HashSet<>();

	public void addNode(Node nodeA) {
		nodes.add(nodeA);
	}

	public Set<Node> getNodes() {
		return nodes;
	}

	public void setNodes(Set<Node> nodes) {
		this.nodes = nodes;
	}

	/**
	 * Prints the graph by iterating over each node and its adjacent nodes.
	 */
	public void printGraph() {
		for (Node node : nodes) {
			System.out.print(node.getName() + ": ");
			Map<Node, Integer> adjacencyList = node.getAdjacentNodes();
			for (Map.Entry<Node, Integer> entry : adjacencyList.entrySet()) {
				Node adjacent = entry.getKey();
				int weight = entry.getValue();
				System.out.print(adjacent.getName() + "(" + weight + ") ");
			}
			System.out.println();
		}
	}

	public void printShortestsPaths() {
		for (Node node : nodes) {
			System.out.println("Node: " + node.getName());
			System.out.println("Shortest Path: " + node.getShortestPath());
			System.out.println("Distance: " + node.getDistance());
			System.out.println();
		}
	}

}
