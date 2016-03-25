package com.yaroslav.shlapak;

import java.util.Scanner;

/**
 * Created by y.shlapak on Mar 25, 2016.
 */
public class Parket {
    static final int MAX_N = 30;

    static final int p000 = 0;
    static final int p001 = 1;
    static final int p011 = 2;
    static final int p100 = 3;
    static final int p110 = 4;
    static final int p111 = 5;



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;



        while ((n = scanner.nextInt()) != -1) {
            System.out.println(getCombinations(n));
        }
    }

    public static int getCombinations(int n) {
        int[][] m = new int[6][MAX_N + 1];
        m[p111][0] = 1;

        for(int i = 1; i <= n; i++) {
            m[p000][i] = m[p111][i - 1];
            m[p001][i] = m[p110][i - 1];
            m[p100][i] = m[p011][i - 1];

            m[p011][i] = m[p100][i - 1] + m[p111][i - 1];
            m[p110][i] = m[p001][i - 1] + m[p111][i - 1];
            m[p111][i] = m[p000][i - 1] + m[p011][i - 1] + m[p110][i - 1];
        }
        return m[p111][n];
    }
}
