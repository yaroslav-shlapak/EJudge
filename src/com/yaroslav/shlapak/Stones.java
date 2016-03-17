package com.yaroslav.shlapak;

import java.util.Scanner;

/**
 * Created by yarl on 17.03.16.
 */
public class Stones {
    static int max = 0;
    static int mult;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int p = scanner.nextInt();



        int[] data = new int[p];
        int maxNumber = n - p + 1;
        for(int i = 0; i < p; i++) {
            data[i] = 1;
        }


        while(data[p - 1] != maxNumber || isAllCellsEqualToNum(data, maxNumber)) {

            recursion(data, maxNumber, 0, p, n);
        }
        System.out.println(max);
/*
        int x = n / p;
        int y = n % p;

        System.out.println(((long) Math.pow(x, p - y) * (long) Math.pow(x + 1, y)));*/
    }

    public static void recursion(int[] data, int maxNumber, int index, int p, int n) {
        //System.out.println(index);
        if(data[index] > maxNumber) {
            data[index] = 1;
            if(index >= p - 1) {
                data[0]++;
                return;
            }
            data[index + 1]++;
            recursion(data, maxNumber, index + 1, p, n);
        } else {
            if(getSum(data) == n) {
                mult = getMult(data);
                if (max < mult) {
                    max = mult;
                }

            }
            data[0]++;
        }
    }

    public static boolean isAllCellsEqualToNum(int[] data, int num) {
        for(int i = 0; i < data.length; i++) {
              if(data[i] != num) {
                  return true;
              }
        }
        return false;
    }

    public static int getSum(int[] data) {
        int sum = 0;
        for(int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum;
    }

    public static int getMult(int[] data) {
        int sum = 1;
        for(int i = 0; i < data.length; i++) {
            sum *= data[i];
        }
        return sum;
    }
}
