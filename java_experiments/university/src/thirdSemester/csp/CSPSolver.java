package thirdSemester.csp;

import java.util.Arrays;

/**
 * This class implements a solution for the Constrained Shortest Path Problem (CSP).
 * The goal is to find the shortest path between two nodes while ensuring that
 * the resource constraint is not exceeded.
 */
public class CSPSolver {
    private Graph graph;
    private int maxResource;

    /**
     * Constructs a CSPSolver with the given graph and maximum resource constraint.
     *
     * @param graph       the graph representing the problem
     * @param maxResource the maximum allowable resource
     */
    public CSPSolver(Graph graph, int maxResource) {
        this.graph = graph;
        this.maxResource = maxResource;
    }

    /**
     * Solves the CSP to find the shortest path from the start node to the target node
     * without exceeding the resource constraint.
     *
     * @param start  the starting node
     * @param target the target node
     * @return the minimum cost to reach the target node within the resource constraint,
     *         or -1 if no valid path exists
     */
    public int solve(int start, int target) {
        int numNodes = graph.getNumNodes();
        int[][] dp = new int[maxResource + 1][numNodes];

        for (int i = 0; i <= maxResource; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][start] = 0;

        for (int r = 0; r <= maxResource; r++) {
            for (int u = 0; u < numNodes; u++) {
                if (dp[r][u] == Integer.MAX_VALUE) continue;
                for (Edge edge : graph.getEdges(u)) {
                    int v = edge.getTo();
                    int cost = edge.getCost();
                    int resource = edge.getResource();

                    if (r + resource <= maxResource) {
                        dp[r + resource][v] = Math.min(dp[r + resource][v], dp[r][u] + cost);
                    }
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int r = 0; r <= maxResource; r++) {
            minCost = Math.min(minCost, dp[r][target]);
        }

        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
}
