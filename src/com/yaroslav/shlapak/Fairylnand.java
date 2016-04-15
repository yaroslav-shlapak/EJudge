//package com.yaroslav.shlapak;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by y.shlapak on Apr 13, 2016.
 */
public class Fairylnand {
    private static int n, m;
    private static int[] coins;
    private static int[] visited;
    private static int[] result;
    private static boolean done = false;
    private static int minSize = (int) 10e9;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        coins = new int[m + 10];
        visited = new int[m + 10];
        result = new int[m + 10];


        for(int i = 0; i < m; i++) {
            coins[i] = scanner.nextInt();
        }
        Arrays.sort(coins, 0, m);
        solve(0, 0, 0);

        if(done) {
            System.out.println(minSize);
            for(int i = 0; i < minSize; i++) {
                System.out.print(result[i] + " ");
            }
            return;
        }

        if(sumOfCoins() < n) {
            System.out.println(-1);
        } else {
            System.out.println(0);
        }
    }
    private static void solve(int index, int sum, int size) {

        if(size >= minSize) {
            return;
        }
        if(sum == n) {
            minSize = size;
            done = true;
            int j = 0;
            for(int i = 0; i < m; i++) {
                if(visited[i] == 1) {
                    result[j] = coins[i];
                    j++;
                }
                if(visited[i] == 2) {
                    result[j] = coins[i];
                    result[j + 1] = coins[i];
                    j += 2;
                }
            }
            return;
        }

        if(index >= m) {
            return;
        }

        for(int i = 0; i <= 2; i++) {
            visited[index] = i;
            //System.out.println(coins[i]);
            solve(index + 1, sum + coins[index] * i, size + i);
        }
    }

    private static int sumOfCoins() {
        int sum = 0;
        for(int i = 0; i < m; i++) {
            sum += coins[i] * 2;
        }
        return sum;
    }
}
