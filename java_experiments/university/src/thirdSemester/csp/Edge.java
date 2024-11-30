package thirdSemester.csp;

public class Edge {
    private int from;
    private int to;
    private int cost;
    private int resource;

    public Edge(int from, int to, int cost, int resource) {
        this.from = from;
        this.to = to;
        this.cost = cost;
        this.resource = resource;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getCost() {
        return cost;
    }

    public int getResource() {
        return resource;
    }
}

