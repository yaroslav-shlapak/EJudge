package com.yaroslav.shlapak;

import java.util.Scanner;

/**
 * Created by y.shlapak on Mar 22, 2016.
 */
public class Ladders {
    public static long counter = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] data = new int[n];

        data[0] = n - 1;
        data[1] = 1;

        recursion(0, data);
        System.out.println(counter);
    }

    public static void recursion( int index, int[] data) {
            if(data[index] > data[index + 1] + 1) {
                data[index + 1]++;
                data[index]--;
                counter++;
                recursion(index, data);
            } else {
                index++;
                data[index + 1]++;
                data[index]--;
                counter++;
                recursion(index, data);
            }
    }
}
