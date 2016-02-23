package com.yaroslav.shlapak;

import java.util.Scanner;

/**
 * Created by yarl on 23.02.16.
 */
public class TankTest {
    static final int MIN_N = 1;
    static final int MAX_N = 1000000;



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        if(n <= 2) {
            System.out.print(0 + " ");
            System.out.println(0);
            return;
        }
        int holeCounter = 0;
        int humpCounter = 0;

        int prev = scanner.nextInt();
        int current = scanner.nextInt();
        int next = scanner.nextInt();
        for(int i = 3; i <= n; i++) {
            if(current > prev && current > next) {
                humpCounter++;
            }
            if(current < prev && current < next) {
                holeCounter++;
            }
            prev = current;
            current = next;
            if(i != n) {
                next = scanner.nextInt();
            }

        }
        System.out.print(humpCounter + " ");
        System.out.println(holeCounter);
    }
}
