package trabalho;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * A node of a graph with a name, a linked list of the shortest paths, the
 * distance from the source, and a list of adjacent nodes.
 */
public class Node {

	private String name;

	private LinkedList<Node> shortestPath = new LinkedList<>();

	private Integer distance = Integer.MAX_VALUE;

	private Map<Node, Integer> adjacentNodes = new HashMap<>();

	public Node(String name) {
		this.name = name;
	}

	/**
     * Adds a destination node with the specified distance.
     *
     * @param destination the destination node
     * @param distance    the distance to the destination node
     */
	public void addEdge(Node destination, int distance) {
		adjacentNodes.put(destination, distance);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Node, Integer> getAdjacentNodes() {
		return adjacentNodes;
	}

	public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public List<Node> getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(LinkedList<Node> shortestPath) {
		this.shortestPath = shortestPath;
	}

	@Override
	public String toString() {
		return "Node " + name;
	}

}
