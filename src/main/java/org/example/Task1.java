package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1{
    static int amount;
    static String name;
    static String colour;

    public static void main(String[] args) {
        System.out.println(task1());
    }

    public static int task1 (){

        getData();

        if (colour.length()!=amount){
            return 0;
        }
        int result = 0;

        String[] splittedName = name.split(" ");
        List<String> splittedColour = new ArrayList<>();

        int k = 0;
        for (String i : splittedName) {
            splittedColour.add(colour.substring(k, k + i.length()));
            k = k + i.length();
        }

        for (String colorRow : splittedColour) {
            for (int i = 0; i < colorRow.length() - 1; i++) {
                if (colorRow.charAt(i) == colorRow.charAt(i + 1)) {
                    result = result + 1;
                    break;
                }
            }
        }
        return result;
    }

    public static void getData(){
        Scanner scanner = new Scanner(System.in);

        amount = scanner.nextInt();
        scanner.nextLine();
        name = scanner.nextLine();
        colour = scanner.nextLine();
        scanner.close();
    }
}