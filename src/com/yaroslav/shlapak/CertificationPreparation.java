package com.yaroslav.shlapak;

import java.util.Scanner;

/**
 * Created by yarl on 29.02.16.
 */
public class CertificationPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt();
        int[] data = new int[len];
        for(int i = 0; i < len; i++) {
            data[i] = scanner.nextInt();
        }


        //int[] data = {4, 3, 5, 1, 5, 6, 2, 7, 3, 8, 4, 2, 3, 5, 1, 7, 9, 6, 7, 7, 10, 3, 10, 8, 9, 2, 7, 10};
        //int len = data.length - 1;

        int maxNum = 0;

        for(int i = 0; i < len; i++) {
            int index = i;
            int num = 0;
            while (index != -1) {
                System.out.print(data[index] + " ");
                index = getNearestMin(data, index);

                num++;
            }
            if(num > maxNum) {
                maxNum = num;
            }
            System.out.println();

        }
        System.out.println(maxNum);
    }

    private static int getNearestMin(int[] data, int index) {

        int indexOfMin = data.length - 1;
        boolean latch = false;
        for(int i = data.length - 1; i > index; i--) {
            if(data[index] < data[i] && data[i] <= data[indexOfMin]) {
                indexOfMin = i;
                latch = true;
            }

        }
        if(latch) {
            return indexOfMin;
        } else {
            return -1;
        }
    }
}
