package secondSemester.dsa;

import java.util.ArrayList;

public class AdjacencyListGraph implements Graph {
    private ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

    public int addNode() {
        // Neuen Knoten anhängen
        // (D.h. leere Nachbarliste an die Adjazenzliste anhängen)
        adjacencyList.add(new ArrayList<>());

        return adjacencyList.size();
    }

    public boolean addEdge(int orig, int dest) {
        // Anzahl Knoten bestimmen
        int numNodes = adjacencyList.size();

        // Parameter prüfen (Knoten vorhanden?)
        if (orig > numNodes || dest > numNodes || orig < 1 || dest < 1)
            return false;

        // Kante bereits vorhanden?
        for (int n : adjacencyList.get(orig - 1)) {
            if (n == dest)
                return false;
        }

        // Zielknoten zur Nachbarliste des Ausgangsknotens hinzufügen
        adjacencyList.get(orig - 1).add(dest);

        return true;
    }
}
