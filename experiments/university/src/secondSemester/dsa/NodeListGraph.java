package secondSemester.dsa;

import java.util.ArrayList;
import java.util.Arrays;

public class NodeListGraph implements Graph {
    // leere Knotenliste [0, 0] erzeugen
    private ArrayList<Integer> nodeList = new ArrayList<>(Arrays.asList(0, 0));
    
    public int addNode() {
        // Knoten anfügen
        nodeList.add(0);

        // Knotenzähler inkrementieren
        int numNodes = nodeList.get(0) + 1;
        nodeList.set(0, numNodes);
        return numNodes;
    }

    public boolean addEdge(int orig, int dest) {
        // Parameter prüfen (Knoten vorhanden?)
        if (orig > nodeList.get(0) || dest > nodeList.get(0)
                || orig < 1 || dest < 1) {
            return false;
        }
        // Startknoten (orig) suchen
        int pos = 2;
        for (int i = 1; i < orig; i++) {
           pos += 1 + nodeList.get(pos); // springe zum naechsten Knoten
        }
        // Kante bereits vorhanden?
        int numSuccessors = nodeList.get(pos);
        for (int i = 1; i <= numSuccessors; i++) {
            if (nodeList.get(pos+i) == dest) {
                return false;
            }
        }
        // Kantenzähler des Startknotens erhöhen
        numSuccessors++;
        nodeList.set(pos, numSuccessors);
        // Zielknoten als Nachfolger einfügen
        // (verschiebt den restlichen Inhalt um 1 nach rechts)
        nodeList.add(pos + numSuccessors, dest);
        // Globalen Kantenzähler inkrementieren
        int numEdges = nodeList.get(1) + 1;
        nodeList.set(1, numEdges);
        return true;
    }
} 
