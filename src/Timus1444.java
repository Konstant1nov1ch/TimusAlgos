import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Timus1444 {
    static final double PI = 3.14159265;
    static class Point {
        double length;
        double degrees;
        int index;
    }

    static int comparePoints(Point p1, Point p2) {
        if (p1.degrees - p2.degrees > 1e-10)
            return 1;
        else if (p1.degrees - p2.degrees < -1e-10)
            return -1;
        else
            return Double.compare(p1.length, p2.length);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        short f_x = input.nextShort();
        short f_y = input.nextShort();
        Point[] dots = new Point[n];
        dots[0] = new Point();
        dots[0].degrees = -1;
        dots[0].length = 0;
        dots[0].index = 1;
        for (int i = 1; i < n; i++) {
            short x = input.nextShort();
            short y = input.nextShort();
            dots[i] = new Point();
            dots[i].index = i + 1;
            dots[i].length = Math.pow((x - f_x), 2) + Math.pow((y - f_y), 2);
            dots[i].degrees = Math.atan2(y - f_y, x - f_x) * 180.0 / PI;
            if (y - f_y < 0) dots[i].degrees += 360;
        }

        Arrays.sort(dots, 1, n, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                return comparePoints(p1, p2);
            }
        });

        int start_point = 1;
        double max_a = dots[1].degrees - dots[n-1].degrees + 360;
        for (int i = 1; i < n - 1; i++) {
            if (dots[i + 1].degrees - dots[i].degrees > max_a) {
                max_a = dots[i + 1].degrees - dots[i].degrees;
                start_point = i + 1;
            }
        }

        System.out.println(n);
        System.out.println(1);
        for (int i = start_point; i < n; i++) {
            System.out.println(dots[i].index);
        }
        for (int i = 1; i < start_point; i++) {
            System.out.println(dots[i].index);
        }
    }
}