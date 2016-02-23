package com.yaroslav.shlapak;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yarl on 23.02.16.
 */
public class VirusNews {
    public static void main(String[] args) {
        // write your code here

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int ans = n;

        int current;
        int[] index = new int[n];
        int[] id = new int[n];
        Node node = new Node(n);

        for(int i = 0; i < n; i++) {
            index[i] = i;
            id[i] = i;
        }
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {

                current = scanner.nextInt();
                if(current == 1) {
                    if (id[i] == index[i]) {
                        if (id[j] == index[j]) {
                            id[j] = id[i];
                        } else {
                            id[i] = id[j];
                        }
                    }

                    System.out.println(Arrays.toString(id));
                    //System.out.println(i + " " + j);

                }
            }
        }
        System.out.println(ans);

    }
}

class Node {
    int index[];
    int id[];

    public Node(int n) {
        index = new int[n];
        id = new int[n];
        for(int i = 0; i < n; i++) {
            index[i] = i;
            id[i] = i;
        }
    }
}

