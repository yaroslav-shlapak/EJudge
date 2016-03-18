package com.yaroslav.shlapak;

import java.util.Arrays;
import java.util.Scanner;
// 32888 2
/**
 * Created by yarl on 17.03.16.
 */


public class MaximalPrize {
    static int max = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        int k = scanner.nextInt();

        int len = n.length();




        int[] data = new int[len];
        for(int i = 0; i < len; i++) {
            data[i] = Integer.parseInt(n.substring(i, i + 1));
        }

        if(k >= len) {
            k = len;
            sort(data, k, len);
            System.out.println(getNumber(data));
            return;
        }

        int[] indices = new int[len];
        int[] dataCopy = data.clone();

        for(int i = 0; i < len; i++) {

            int max = 0;
            int index = 0;
            for(int j = 0; j < len; j++) {
                if(indices[j] == 0 && data[j] > max) {
                    max = data[j];
                    index = j + 1;
                }
            }
            indices[i] = index;
        }

        System.out.println(Arrays.toString(indices));

        System.out.println(getNumber(data));
    }

    public static void sort(int[] data, int k, int len) {
        for(int i = 0; i < k; i++) {
            int[] d = getMax(data, i, len);
            if (d[0] > data[i]) {
                swap(data, i, d[1]);
            }
        }
    }

    public static int getNumber(int[] n) {
        //System.out.println(n.toString());
        int ret = 0;
        for(int i = 0; i < n.length; i++) {
            ret += n[n.length - i - 1] * pow(10, i);
        }
        return ret;
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

    public static int[] getMax(int[] data, int start, int end) {
        int max = 0;
        int index = 0;
        for(int i = start; i < end; i++) {
            if(data[i] > max) {
                max = data[i];
                index = i;
            }
        }
        return new int[]{max, index};
    }

}
