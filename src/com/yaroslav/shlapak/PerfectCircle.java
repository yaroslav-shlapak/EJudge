//package com.yaroslav.shlapak;

import java.util.Scanner;

/**
 * Created by yarl on 24.02.16.
 */
public class PerfectCircle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int radius = scanner.nextInt();
        /*if(radius < 1) {
            System.out.println(0);
            return;
        }*/

        double len;
        int counter = radius * radius;

        for(int i = 1; i <= radius; i++) {
            for(int j = 1; j <= radius; j++) {
                len = Math.sqrt(i * i + j * j);
                if(len > radius) {
                    counter--;
                }
            }
        }

        System.out.println(counter * 4);

    }
}
