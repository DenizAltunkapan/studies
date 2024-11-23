package secondSemester.dsa;

import java.util.ArrayList;
import java.util.Arrays;

public class EdgeListGraph implements Graph {
    // leere Kantenliste [0, 0] erzeugen
    private ArrayList<Integer> edgeList = new ArrayList<>(Arrays.asList(0, 0));

    public int addNode() {
        int numNodes = edgeList.get(0) + 1;
        edgeList.set(0, numNodes);
        return numNodes;
    }

    public boolean addEdge(int orig, int dest) {
        // Parameter prüfen (Knoten existieren?)
        if (orig > edgeList.get(0) || dest > edgeList.get(0)
                || orig < 1 || dest < 1) {
            return false;
        }
        // Kante existiert bereits?
        for (int i = 2; i < edgeList.size(); i += 2) {
            if (edgeList.get(i) == orig && edgeList.get(i + 1) == dest)
                return false;
        }
        // Kante einfügen und Kantenzähler inkrementieren
        edgeList.add(orig);
        edgeList.add(dest);
        int numEdges = edgeList.get(1) + 1;
        edgeList.set(1, numEdges);
        return true;
    }

    public ArrayList<Integer> getEdgeList() {
        return edgeList;
    }

    public int getNumNodes() {
        return edgeList.get(0);
    }

    public int getNumEdges() {
        return edgeList.get(1);
    }
}
