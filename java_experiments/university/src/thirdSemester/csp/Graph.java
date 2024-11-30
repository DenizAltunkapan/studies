package thirdSemester.csp;

import java.util.ArrayList;
import java.util.List;

/**
 * The class represents a directed graph with weighted edges.
 * Each node in the graph has a list of edges that originate from it.
 */
public class Graph {

    private int numNodes;
    private List<Edge>[] adjacencyList;

    /**
     * Constructor that creates a graph with a given number of nodes.
     * Each node initially has an empty list of edges.
     *
     * @param numNodes The number of nodes in the graph.
     */
    @SuppressWarnings("unchecked")
    public Graph(int numNodes) {
        this.numNodes = numNodes;
        this.adjacencyList = new ArrayList[numNodes];
        for (int i = 0; i < numNodes; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    /**
     * Adds a directed edge to the graph from one node to another.
     * Each edge has an associated cost and resource.
     *
     * @param from The node from which the edge originates.
     * @param to The node to which the edge points.
     * @param cost The cost associated with the edge.
     * @param resource The resource associated with the edge.
     */
    public void addEdge(int from, int to, int cost, int resource) {
        Edge edge = new Edge(from, to, cost, resource);
        adjacencyList[from].add(edge);
    }

    /**
     * Returns the list of edges that originate from a given node.
     *
     * @param node The node for which the outgoing edges are returned.
     * @return A list of edges originating from the given node.
     */
    public List<Edge> getEdges(int node) {
        return adjacencyList[node];
    }

    /**
     * Returns the total number of nodes in the graph.
     * @return The number of nodes in the graph.
     */
    public int getNumNodes() {
        return numNodes;
    }

}
