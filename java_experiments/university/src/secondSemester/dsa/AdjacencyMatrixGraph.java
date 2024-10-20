package secondSemester.dsa;

public class AdjacencyMatrixGraph implements Graph {
    private boolean[][] adjacencyMatrix = null;

    public int addNode() {
        // (Alte) Anzahl Knoten bestimmen
        int numNodes = (adjacencyMatrix == null) ? 0 : adjacencyMatrix.length;

        // Neue Matrix mit einer Zeile & Spalte mehr
        boolean[][] newAdjacencyMatrix = new boolean[numNodes + 1][numNodes + 1];

        // Matrix umkopieren
        for (int i = 0; i <= numNodes; i++) {
            for (int j = 0; j <= numNodes; j++) {
                if ((i == numNodes) || (j == numNodes))
                    newAdjacencyMatrix[i][j] = false; // noch keine Kanten
                else
                    newAdjacencyMatrix[i][j] = adjacencyMatrix[i][j];
            }
        }
        adjacencyMatrix = newAdjacencyMatrix;

        return numNodes + 1;
    }

    public boolean addEdge(int orig, int dest) {
        // Anzahl Knoten bestimmen
        int numNodes = (adjacencyMatrix == null) ? 0 : adjacencyMatrix.length;

        // Parameter prüfen (Knoten vorhanden?)
        if (orig > numNodes || dest > numNodes || orig < 1 || dest < 1)
            return false;

        // Kante bereits vorhanden?
        if (adjacencyMatrix[orig - 1][dest - 1])
            return false;

        // Kante einfügen
        adjacencyMatrix[orig - 1][dest - 1] = true;
        return true;
    }
}
