//package com.yaroslav.shlapak;

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

        System.out.println(longestIncreasingSubsequence(data));
    }


    public static int longestIncreasingSubsequence(int[] input) {

        if(input == null || input.length == 0) {
            return 0;
        }

        int n = input.length;
        // lisLength[i] - Length of Longest Increasing Subsequence in input[0..i]
        int[] lisLength = new int[n];
        int maxLength = 1;
        lisLength[0] = 1;
        for (int i = 1; i < n; i++) {
            lisLength[i] = 1;
            for (int j = 0; j < i; j++) {
                if (input[i] > input[j] && lisLength[i] < lisLength[j] + 1) {
                    lisLength[i] = lisLength[j] + 1;
                }
            }
            // Update the length of longest increasing subsequence found till now
            if(maxLength < lisLength[i]) {
                maxLength = lisLength[i];
            }
        }
        return maxLength;
    }
}
