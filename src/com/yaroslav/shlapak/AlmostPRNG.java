package com.yaroslav.shlapak;

import java.util.Scanner;

/**
 * Created by yarl on 22.02.16.
 */
public class AlmostPRNG {
    static final int MAX_LENGTH = 100000;
    static final int MAX_SEQUENCE = 6;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        int current = s.charAt(0);
        int next = s.charAt(1);
        int counter = 1;
        int len = s.length();
        if(len > MAX_LENGTH) {
            len = MAX_LENGTH;
        }
        if(len <= 6) {
            System.out.println("OK");
            return;
        }
        for(int i = 2; i <= len; i++) {
            //System.out.println(current);
            if(current == next) {
                counter++;
            } else {
                counter = 1;
            }
            if(counter > MAX_SEQUENCE) {
                System.out.println("FAIL");
                return;
            }

            if(i == len) {
                System.out.println("OK");
                return;
            }
            current = next;
            next = s.charAt(i);
        }
    }
}
