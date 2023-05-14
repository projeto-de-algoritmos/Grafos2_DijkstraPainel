package trabalho;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

/**
 * This class implements the Dijkstra's algorithm to find the shortest paths
 * from a source node to all other nodes in a graph.
 */
public class Dijkstra {

	/**
	 * Finds the shortest paths from a source node to all other nodes in the graph.
	 *
	 * @param graph  the graph
	 * @param source the source node
	 * @return the graph with updated shortest paths
	 */
	public static Graph calculateShortestPathFromSource(Graph graph, Node source) {

		source.setDistance(0);

		Set<Node> settledNodes = new HashSet<>();
		Set<Node> unsettledNodes = new HashSet<>();
		unsettledNodes.add(source);

		while (unsettledNodes.size() != 0) {
			Node currentNode = getLowestDistanceNode(unsettledNodes);
			unsettledNodes.remove(currentNode);
			for (Entry<Node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
				Node adjacentNode = adjacencyPair.getKey();
				Integer edgeWeigh = adjacencyPair.getValue();

				if (!settledNodes.contains(adjacentNode)) {
					updateShortestPath(adjacentNode, edgeWeigh, currentNode);
					unsettledNodes.add(adjacentNode);
				}
			}
			settledNodes.add(currentNode);
		}
		return graph;
	}

	/**
	 * Updates the distance and shortest path of an adjacent node if a shorter path
	 * is found.
	 *
	 * @param adjacent  the adjacent node
	 * @param edgeWeigh the weight of the edge between the current node and the
	 *                  adjacent node
	 * @param current   the current node
	 */
	private static void updateShortestPath(Node adjacent, Integer edgeWeigh, Node sourceNode) {
		Integer sourceDistance = sourceNode.getDistance();
		if (sourceDistance + edgeWeigh < adjacent.getDistance()) {
			adjacent.setDistance(sourceDistance + edgeWeigh);
			LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
			shortestPath.add(sourceNode);
			adjacent.setShortestPath(shortestPath);
		}
	}

	/**
	 * Finds the node with the lowest distance from the source among the unsettled
	 * nodes.
	 *
	 * @return the node with the lowest distance
	 */
	private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
		Node lowestDistanceNode = null;
		int lowestDistance = Integer.MAX_VALUE;
		for (Node node : unsettledNodes) {
			int nodeDistance = node.getDistance();
			if (nodeDistance < lowestDistance) {
				lowestDistance = nodeDistance;
				lowestDistanceNode = node;
			}
		}
		return lowestDistanceNode;
	}
}
