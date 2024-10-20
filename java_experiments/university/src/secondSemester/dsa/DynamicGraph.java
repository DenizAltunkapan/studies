package secondSemester.dsa;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;
import java.util.TreeSet;

public class DynamicGraph implements Graph {
    private class GraphNode implements Comparable<GraphNode> {
        // alle Elemente von TreeSet muessen Comparable implementieren

        int key; // Nummerierung des Knotens
        Set<GraphNode> outgoingEdges = new TreeSet<>();

        GraphNode(int k) {
            key = k;
        }

        @Override
        public int compareTo(GraphNode other) {
            return ((Integer) key).compareTo(other.key);
        }
    }

    // Menge der Einstiegspunkte
    private Set<GraphNode> entryPoints = new TreeSet<>();

    // Knotenzähler
    private int maxKey = 0;

    public int addNode() {
        maxKey++;
        entryPoints.add(new GraphNode(maxKey));
        return maxKey;
    }

    private GraphNode findNode(int k) {
        Deque<GraphNode> queue = new ArrayDeque<>();
        queue.addAll(entryPoints);
        Set<GraphNode> found = new TreeSet<>();
        found.addAll(entryPoints);
        while(!queue.isEmpty()) {
            GraphNode n = queue.poll(); // Entfernt den vordersten Eintrag in queue
            if (n.key == k) {
                return n;
            }
            for (GraphNode destNode : n.outgoingEdges) {
                if (!found.contains(destNode)) {
                   queue.add(destNode); // Fügt destNode an die queue an
                   found.add(destNode);
                }
            }
        }
        return null;
    }

    public boolean addEdge(int orig, int dest) {
        // Ausgangs- und Zielknoten suchen
        GraphNode origNode = findNode(orig);
        GraphNode destNode = findNode(dest);

        // Ausgangs- oder Zielknoten nicht im Graph?
        if (origNode == null || destNode == null) {
            return false;
        }

        // Kante einfügen
        origNode.outgoingEdges.add(destNode);

        // Zielknoten aus entryPoints loeschen 
        entryPoints.remove(destNode);
        // Ausgangsknoten noch erreichbar?
        if (findNode(orig) == null) {
           entryPoints.add(origNode);
        }

        return true;
    }
}
