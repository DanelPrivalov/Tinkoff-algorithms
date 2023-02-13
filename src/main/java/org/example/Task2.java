package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {

    static int[] values;
    static int[] amounts;
    static int fourthCurrencyNOK;
    static int[] fourthCurrencyProportion = new int[3];
    static int fourthCurrencyTotal = 0;
    static int fourthCurrencyCount;
    static int count = 0;

    public static void main(String[] args) {
        System.out.println(task2());
    }
    public static int task2 (){
        getData();
        fourthCurrencyNOK = findLCM(values[0], findLCM(values[1], values[2]));

        for (int i=0; i< values.length; i++){
            fourthCurrencyProportion[i] = fourthCurrencyNOK/values[i];
        }

        for (int i=0; i< fourthCurrencyProportion.length; i++){
            fourthCurrencyTotal += fourthCurrencyProportion[i] *amounts[i];
        }

        fourthCurrencyCount = fourthCurrencyTotal;

        Arrays.sort(fourthCurrencyProportion);

        return (algorithm(fourthCurrencyCount));
    }

    public static int algorithm(int number) {
        if (number < 0) {
            return count;
        }

        if ((fourthCurrencyTotal - number) % fourthCurrencyProportion[1] == 0 && (fourthCurrencyTotal - number) % fourthCurrencyProportion[2] == 0) {
            for (int i = fourthCurrencyTotal - number; i >= 0; i -= fourthCurrencyProportion[0]) {
                if (i % fourthCurrencyProportion[2] == 0) {
                    count += 1;
                }
            }
            algorithm(number - fourthCurrencyProportion[0]);
        } else if ((fourthCurrencyTotal - number) % fourthCurrencyProportion[1] == 0) {
            count = algorithm(number - fourthCurrencyProportion[0]);
        }
        else if ((fourthCurrencyTotal - number) % fourthCurrencyProportion[2] == 0) {
            count = algorithm(number - fourthCurrencyProportion[0]);
        }
        else {
            algorithm(number - fourthCurrencyProportion[0]);
        }

        return count;
    }

    static void getData(){
        Scanner scanner = new Scanner(System.in);
        String raw_value  = scanner.nextLine();
        String raw_amount = scanner.nextLine();

        values = Arrays.stream(raw_value.split(" ")).mapToInt(Integer::parseInt).toArray();
        amounts = Arrays.stream(raw_amount.split(" ")).mapToInt(Integer::parseInt).toArray();

        scanner.close();
    }

    public static int findLCM(int a, int b) {
        return a / findGCD(a, b) * b;
    }

    public static int findGCD(int a, int b) {
        return b == 0 ? a : findGCD(b, a % b);
    }
}