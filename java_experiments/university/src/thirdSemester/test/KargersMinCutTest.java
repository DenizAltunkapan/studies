package thirdSemester.test;

import secondSemester.dsa.EdgeListGraph;
import thirdSemester.KargersMinCut;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KargersMinCutTest {

    /**
     * WARNING: TEST MIGHT FAIL SINCE IT'S A RANDOMIZED ALGORITHM! TRY SEVERAL TIMES.
     */

    @Test
    public void testSimpleGraph() {
        EdgeListGraph graph = new EdgeListGraph();
        graph.addNode();
        graph.addNode();
        graph.addEdge(1, 2);

        int minCut = KargersMinCut.findMinCut(graph);
        assertEquals(1, minCut);
    }

    @Test
    public void testTriangleGraph() {
        EdgeListGraph graph = new EdgeListGraph();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(1, 3);

        int minCut = KargersMinCut.findMinCut(graph);
        assertEquals(2, minCut);
    }

    @Test
    public void testCompleteGraph4Nodes() {
        EdgeListGraph graph = new EdgeListGraph();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        int minCut = KargersMinCut.findMinCut(graph);
        assertEquals(3, minCut);
    }


    @Test
    public void testLargeGraph() {
        EdgeListGraph graph = new EdgeListGraph();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        int minCut = KargersMinCut.findMinCut(graph);
        assertEquals(2, minCut);
    }

    @Test
    public void testComplexGraph() {
        EdgeListGraph graph = new EdgeListGraph();
        for (int i = 0; i < 7 ; i++) {
            graph.addNode();
        }
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 6);
        graph.addEdge(1, 5);
        graph.addEdge(4, 5);
        graph.addEdge(7, 5);
        graph.addEdge(7, 6);
        int minCut = KargersMinCut.findMinCut(graph);
        assertEquals(2, minCut);
    }
}
