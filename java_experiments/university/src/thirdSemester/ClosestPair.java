package thirdSemester;
import java.util.*;

public class ClosestPair {

    public static double closestPair(Point[] points) {
        Point[] px = Arrays.copyOf(points, points.length);
        Point[] py = Arrays.copyOf(points, points.length);

        Arrays.sort(px, Comparator.comparingDouble(p -> p.x));
        Arrays.sort(py, Comparator.comparingDouble(p -> p.y));

        return closestPairRecursive(px, py);
    }

    private static double closestPairRecursive(Point[] X, Point[] Y) {
        int n = X.length;

        if (n == 2) return distance(X[0], X[1]);
        if (n == 3) return Math.min(distance(X[0], X[1]),
                Math.min(distance(X[0], X[2]), distance(X[1], X[2])));

        int mid = n / 2;
        Point midPoint = X[mid];

        Point[] XL = Arrays.copyOfRange(X, 0, mid);
        Point[] XR = Arrays.copyOfRange(X, mid, n);

        Point[] YL = Arrays.stream(Y).filter(p -> p.x <= midPoint.x).toArray(Point[]::new);
        Point[] YR = Arrays.stream(Y).filter(p -> p.x > midPoint.x).toArray(Point[]::new);

        double dL = closestPairRecursive(XL, YL);
        double dR = closestPairRecursive(XR, YR);

        double d = Math.min(dL, dR);

        List<Point> strip = new ArrayList<>();
        for (Point p : Y) {
            if (Math.abs(p.x - midPoint.x) < d) strip.add(p);
        }

        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < Math.min(strip.size(), i + 7); j++) {
                d = Math.min(d, distance(strip.get(i), strip.get(j)));
            }
        }

        return d;
    }

    private static double distance(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }
}
