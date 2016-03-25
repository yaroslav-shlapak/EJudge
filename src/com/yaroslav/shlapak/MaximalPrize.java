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

/*
        int[] indices = new int[len];
        int[] dataCopy = data.clone();

        for(int i = 0; i < len; i++) {

            int max = 0;
            int index = 0;
            for(int j = 0; j < len; j++) {
                if(indices[j] == 0 && data[j] > max) {
                    max = data[j];
                    index = j;
                }
            }
            indices[index] = i + 1;
        }
        int[] dd = getMax(data, 0, len);


        int c = 0;
        int cc = 0;

        for(int i = 0; i < len; i++) {
            if(data[i] == dd[0]) {
                c++;
            }
        }
        for(int i = len - 1; i >= 0; i--) {
            if(c > k && data[i] == dd[0]) {
                cc++;
                indices[i]--;
                if(cc > k) {
                    indices[i] = k + 1;
                }
            }

        }

        //System.out.println(Arrays.toString(indices));
        int counter = 1;
        for(int i = 0; i < k; i++) {
            boolean flag = false;
            for(int j = 0; j < len; j++) {
                //System.out.println(indices[i] - 1 == j);
                if(indices[i] - 1 == j && indices[j] - 1 == i) {
                    swap(data, i, j);
                    flag = true;
                    if(++counter > k) {
                        System.out.println(getNumber(data));
                        return;
                    }
                    break;
                } else {

                }
            }
            if(flag) {
                continue;
            }
            int[] d = getMax(data, i, len);
            if (d[0] > data[i]) {
                swap(data, i, d[1]);
                if(++counter > k) {
                    System.out.println(getNumber(data));
                    return;
                }
            }
            break;
        }*/

        int[] prev = new int[2];
        int[] d = new int[2];
        if(k >= 2) {
            for(int i = 0; i < k; i++) {
                prev = d;
                d = getMax(data, i, len - i);
                if (d[0] > data[i]) {
                    swap(data, i, d[1]);
                    d[1] = i;
                }
            }
            if(data[prev[1]] > data[d[1]] && prev[1] > d[1] ||
                    data[prev[1]] < data[d[1]] && prev[1] < d[1]) {
                swap(data, prev[1], d[1]);
            }
            System.out.println(getNumber(data));
            return;
        }

        if(k >= len) {
            k = len;
            sort(data, k, len);
            System.out.println(getNumber(data));
            return;
        }

        if(k == 1) {
            sort(data, k, len);
            System.out.println(getNumber(data));
            return;
        }

        sort(data, k, len);
        System.out.println(getNumber(data));
        return;

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
        for(int i = end - 1; i >= start; i--) {
            //System.out.println(data[i]);;
            if(data[i] > max) {

                max = data[i];

                index = i;
            }
        }

        return new int[]{max, index};
    }

}
