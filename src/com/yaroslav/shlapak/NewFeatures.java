package com.yaroslav.shlapak;

import java.util.Scanner;

public class NewFeatures {
    static final int MIN_RESP = 1;
    static final int MAX_RESP = 2000000;

    static final int MIN_FEATURE = 1;
    static final int MAX_FEATURE = 10000;
    static final int N = MAX_FEATURE + 1;

    public static void main(String[] args) {
	// write your code here

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        if(n > MAX_RESP) {
            n = MAX_RESP;
        }
        if(n < MIN_RESP) {
            System.out.print(0);
            return;
        }
        int[] features = new int[N];

        int feature;
        for(int i = 0; i < n; i++) {
            feature = scanner.nextInt();
            if(feature >= MIN_FEATURE && feature <= MAX_FEATURE) {
                features[feature]++;
            }
        }
        getMax(features);
    }
    public static int[] getMax(int[] features ) {
        int maxArr[] =  new int[N];
        int max = 0;
        int maxNumber = 0;

        for(int i = 0; i < N; i++) {
            if(features[i] > max) {
                max = features[i];
            }
        }

        for(int i = 0; i < N; i++) {
            if(features[i] == max) {
                maxArr[maxNumber] = i;
                maxNumber++;
            }
        }

        int returnArr[] = new int[maxNumber];
        for(int i = 0; i < maxNumber; i++) {
            returnArr[i] = maxArr[i];
            System.out.print(returnArr[i] + " ");
        }
        return returnArr;
    }
}
