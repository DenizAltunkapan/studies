package thirdSemester;
import secondSemester.dsa.EdgeListGraph;
import java.util.ArrayList;
import java.util.Random;

/**
 * Implementation of Karger's Min-Cut Algorithm.
 * This is a Monte-Carlo algorithm that uses random edge contractions to find the minimum cut (Min-Cut)
 * in an undirected graph.
 */
public class KargersMinCut {

    /**
     * Finds the minimum cut in a given graph.
     * Repeats the algorithm multiple times to maximize the probability of success.
     *
     * @param graph the input graph
     * @return the size of the minimum cut
     */
    public static int findMinCut(EdgeListGraph graph) {
        int minCut = Integer.MAX_VALUE;
        int numTrials = (int) Math.pow(graph.getNumNodes(), 2);

        for (int i = 0; i < numTrials; i++) {
            EdgeListGraph tempGraph = cloneGraph(graph);
            int cut = kargerMinCut(tempGraph);
            minCut = Math.min(minCut, cut);
        }

        return minCut;
    }

    /**
     * Contracts an edge between two nodes in the graph, merging the destination node into the origin node.
     * Updates the graph by removing self-loops and decreasing the number of nodes.
     *
     * @param graph the input graph
     * @param orig the origin node of the edge
     * @param dest the destination node of the edge
     */
    private static void contractEdge(EdgeListGraph graph, int orig, int dest) {
        ArrayList<Integer> edgeList = graph.getEdgeList();
        for (int i = 2; i < edgeList.size(); i++) {
            if (edgeList.get(i) == dest) {
                edgeList.set(i, orig);
            }
        }

        for (int i = edgeList.size() - 2; i >= 2; i -= 2) {
            if (edgeList.get(i) == edgeList.get(i + 1)) {
                edgeList.remove(i + 1);
                edgeList.remove(i);
                graph.getEdgeList().set(1, graph.getNumEdges() - 1);
            }
        }

        graph.getEdgeList().set(0, graph.getNumNodes() - 1);
    }


    /**
     * Creates a deep copy of the input graph.
     *
     * @param graph the original graph to clone
     * @return a new graph object with the same nodes and edges as the original
     */
    private static EdgeListGraph cloneGraph(EdgeListGraph graph) {
        EdgeListGraph clone = new EdgeListGraph();
        ArrayList<Integer> originalEdges = graph.getEdgeList();
        clone.getEdgeList().set(0, originalEdges.get(0));
        clone.getEdgeList().set(1, originalEdges.get(1));
        for (int i = 2; i < originalEdges.size(); i++) {
            clone.getEdgeList().add(originalEdges.get(i));
        }

        return clone;
    }

    /**
     * Executes a single run of Karger's Min-Cut algorithm on a graph.
     * This function repeatedly contracts random edges until only two nodes remain.
     *
     * @param graph the input graph
     * @return the number of edges in the resulting cut
     */
    private static int kargerMinCut(EdgeListGraph graph) {
        Random random = new Random();
        ArrayList<Integer> edgeList = graph.getEdgeList();

        while (graph.getNumNodes() > 2) {
            int numEdges = graph.getNumEdges();
            int edgeIndex = random.nextInt(numEdges) * 2 + 2;
            int orig = edgeList.get(edgeIndex);
            int dest = edgeList.get(edgeIndex + 1);
            contractEdge(graph, orig, dest);
        }

        return graph.getNumEdges();
    }

}
