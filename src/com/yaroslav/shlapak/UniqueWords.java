package com.yaroslav.shlapak;

import java.util.Scanner;

/**
 * Created by yarl on 23.02.16.
 */
public class UniqueWords {
    static final int MAX_LENGTH = 100001;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        int len = s.length();
        if(len > MAX_LENGTH) {
            len = MAX_LENGTH;
        }
        if(len < 1) {
            return;
        }
        s = s.substring(0, len);
        StringBuffer output = new StringBuffer();
        StringBuffer input = new StringBuffer(s);
        int counter = 0;
        for(int i = 0; i < len; i++) {
            if(i < len - 1 && input.charAt(i) == input.charAt(i + 1)) {
                i++;
            } else {
                if(counter == 0 || output.charAt(counter - 1) != input.charAt(i)) {
                    output.append(input.charAt(i));
                    counter++;
                } else {
                    output.deleteCharAt(counter - 1);
                    counter--;
                }
            }
        }
        System.out.println(output);
    }

}