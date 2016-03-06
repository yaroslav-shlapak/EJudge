package com.yaroslav.shlapak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by y.shlapak on Mar 04, 2016.
 */
public class MountainRoutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n, k, a, b, d;
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = scanner.nextInt();
        b = scanner.nextInt();
        d = scanner.nextInt();

        int[][] routes = new int[n][n];
        for(int horz, vert, i = 0; i < k; i++) {
            horz = scanner.nextInt() - 1;
            vert = scanner.nextInt() - 1;
            System.out.print(horz + " " + vert + "\n");
            routes[horz][vert] = 1;
        }
        for(int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(routes[i]));
        }

        Stack routesStack = new Stack(100);
        while()
    }
}

class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public Stack(int s) {
        maxSize = s;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int j) {
        stackArray[++top] = j;
    }
    public long pop() {
        return stackArray[top--];
    }
    public long peek() {
        return stackArray[top];
    }
    public boolean isEmpty() {
        return (top == -1);
    }
    public boolean isFull() {
        return (top == maxSize);
    }
}