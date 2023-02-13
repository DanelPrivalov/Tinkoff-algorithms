package org.example;
import java.util.Scanner;

public class Task4 {
    static double radius;
    static double singleSector;
    static int n;

    public static void main(String[] args) {
        getData();
        singleSector = 360.0 / n;
        double radian = 180 * Math.PI/180;
        radius = (1 / (2 * Math.sin(radian / n)));
        System.out.format("%.6f", task4(n, radius));
    }
    public static double task4 (int n, double radius) {
        if (n < 3) {
            return 0;
        }
        double returnSquare;
        int step = n % 3 == 2 ? n / 3 + 1 : n / 3;
        int firstPoint = 0;
        int secondPoint = firstPoint+step;
        int thirdPoint = secondPoint + step;
        double[] firstCoordinates = {radius, 0};
        double[] secondCoordinates = {radius * Math.cos(singleSector * secondPoint * Math.PI/180), radius * Math.sin(singleSector * secondPoint * Math.PI/180)};
        double[] thirdCoordinates = {radius * Math.cos(singleSector * thirdPoint * Math.PI/180), radius * Math.sin(singleSector * thirdPoint* Math.PI/180)};

        double square = Math.abs(((secondCoordinates[0] - firstCoordinates[0]) * (thirdCoordinates[1] - firstCoordinates[1])
                - (thirdCoordinates[0] - firstCoordinates[0]) * (secondCoordinates[1] - firstCoordinates[1]))) / 2;

        int thirdStep;
        if (n % 3 == 0) {
            thirdStep = step - 1;
        } else if (n % 3 == 1) {
            thirdStep = step;
        } else {
            thirdStep = step + 1;
        }
        returnSquare = square + 2 * task4(step-1, radius)
                + task4(thirdStep, radius);

        return returnSquare;
    }

    public static void getData() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.close();
    }
}