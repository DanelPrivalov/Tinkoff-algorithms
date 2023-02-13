package org.example;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Task3{
    static int number;

    public static void main(String[] args) {
        getData();
        System.out.println(task3(number));

    }
    public static String task3 (int number) {
        Map<Integer, String> map = new TreeMap<>();
        for (int first = 0; first < number; first++) {
            for (int second = 0; second < number; second++) {
                if (first + second == number) {
                    int lcm = first * second / findGCD(first, second);
                    map.put(lcm, first + " " + second);
                }
            }
        }
        return map.entrySet().iterator().next().getValue();
    }

    public static int findGCD(int a, int b) {
        return b == 0 ? a : findGCD(b, a % b);
    }

    public static void getData() {
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        scanner.close();
    }
}