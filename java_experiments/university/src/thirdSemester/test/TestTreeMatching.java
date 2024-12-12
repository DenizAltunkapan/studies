package thirdSemester.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import thirdSemester.treeMatching.TreeMatching;
import thirdSemester.treeMatching.UndirectedAdjacencyListGraph;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestTreeMatching {
    UndirectedAdjacencyListGraph graph;

    @BeforeEach
    void setUp() {
        graph = new UndirectedAdjacencyListGraph();
        for (int i = 0; i < 14; i++) {
            graph.addNode();
        }
    }
    @Test
    void test1() {
        graph.addEdge(0, 1, 20);
        graph.addEdge(0, 2, 30);
        graph.addEdge(1, 3, 40);
        graph.addEdge(1, 4, 10);
        graph.addEdge(2, 5, 20);
        graph.addEdge(3, 6, 30);
        graph.addEdge(3, 7, 30);
        graph.addEdge(5, 8, 40);
        graph.addEdge(5, 9, 10);

        TreeMatching treeMatching = new TreeMatching(graph);
        assertEquals(110,treeMatching.getMaxMatching(0,-1));
    }

    @Test
    void test2() {
        graph.addEdge(0, 1, 20);
        graph.addEdge(0, 2, 30);
        graph.addEdge(0, 3, 40);
        graph.addEdge(1, 4, 10);
        graph.addEdge(1, 5, 20);
        graph.addEdge(2, 6, 20);
        graph.addEdge(3, 7, 30);
        graph.addEdge(5, 8, 10);
        graph.addEdge(5, 9, 20);
        graph.addEdge(7, 10, 10);
        graph.addEdge(7, 11, 10);
        graph.addEdge(7, 12, 5);
        TreeMatching treeMatching = new TreeMatching(graph);
        assertEquals(100,treeMatching.getMaxMatching(0,-1));
    }

    @Test
    void test3() {
        graph.addEdge(0, 1, 20);
        graph.addEdge(0, 2, 30);
        graph.addEdge(0, 3, 40);
        graph.addEdge(0, 4, 50);
        graph.addEdge(1, 5, 20);
        graph.addEdge(2, 6, 20);
        graph.addEdge(3, 7, 30);
        graph.addEdge(5, 8, 10);
        graph.addEdge(5, 9, 20);
        graph.addEdge(7, 10, 10);
        graph.addEdge(4, 11, 50);
        graph.addEdge(4, 12, 20);
        TreeMatching treeMatching = new TreeMatching(graph);
        assertEquals(140,treeMatching.getMaxMatching(0,-1));
    }

    @Test
    void emptyTree() {
        TreeMatching treeMatching = new TreeMatching(graph);
        assertEquals(0,treeMatching.getMaxMatching(0,-1));
    }
}
