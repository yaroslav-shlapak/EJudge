package com.yaroslav.shlapak;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yarl on 17.03.16.
 */
public class MaximalPrize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        int k = scanner.nextInt();

        int len = n.length();
        int[] data = new int[len];
        for(int i = 0; i < len; i++) {
            data[i] = Integer.parseInt(n.substring(i, i + 1));
        }

        //System.out.println(Arrays.toString(data));

        for(int i = 0; i < k; i++) {
            int[] d = getMax(data, i);
            if(d[0] > data[i]) {
                swap(data, i, d[1]);
            }
        }
        for(int i = 0; i < len; i++) {
            System.out.print(data[i]);
        }
        System.out.println();

    }

    public static void swap(int[] data, int from, int to) {
        int temp = data[from];
        data[from] = data[to];
        data[to] = temp;
    }
    public static int pow(int x, int y) {
        int power = 1;
        for(int i = 0; i < y; i++) {
            power *= x;
        }
        return power;
    }

    public static int[] getMax(int[] data, int start) {
        int max = 0;
        int index = 0;
        for(int i = start; i < data.length; i++) {
            if(data[i] > max) {
                max = data[i];
                index = i;
            }
        }
        return new int[]{max, index};
    }
}
