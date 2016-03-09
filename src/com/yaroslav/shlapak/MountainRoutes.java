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

/*
6 11 2 5 3
1 2
1 3
1 5
2 1
2 4
3 4
1 6
6 5
3 5
4 3
4 1
*/

        int n, k, a, b, d;
        n = scanner.nextInt(); // number of hostels
        k = scanner.nextInt(); // number of routes
        a = scanner.nextInt(); // number of starting hostel
        b = scanner.nextInt(); // number of ending hostel
        d = scanner.nextInt(); // number of max days

        int[][] routes = new int[n][n];
        for(int horz, vert, i = 0; i < k; i++) {
            horz = scanner.nextInt() - 1;
            vert = scanner.nextInt() - 1;
            //System.out.print(horz + " " + vert + "\n");
            routes[horz][vert] = 1;
        }
        int[] forbid = new int[n];
/*
        for(int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(routes[i]));
        }*/

        Stack routesStack = new Stack(100);
        Stack daysStack = new Stack(100);
        routesStack.push(a);
        daysStack.push(0);
        int counter = 0;
        while(!routesStack.isEmpty()) {

            int currentHostel = routesStack.pop();
            System.out.println("currentHostel = " + currentHostel);

            int numberOfDays = daysStack.pop();
            //System.out.println("numberOfDays = " + numberOfDays);


            if(currentHostel == b && numberOfDays <= d) {
                counter++;
                continue;
            }
            if(numberOfDays > d) {
                continue;
            }

            for(int i = 0; i < n; i++) {
                if(routes[currentHostel - 1][i] == 1 && forbid[i] == 0) {
                    if(numberOfDays + 1 <= d) {
                        routesStack.push(i + 1);
                        daysStack.push(numberOfDays + 1);
                        forbid[i] = 0;
                    }
                }
            }
            System.out.println(Arrays.toString(routesStack.stackArray));
            forbid[currentHostel - 1] = 1;

            /*for(int i = 0; i < n; i++) {
                System.out.println(Arrays.toString(routes[i]));
            }
            System.out.println("counter = "  + counter);
            System.out.println(counter);*/

        }
        System.out.println(counter);
    }
}

class Stack {
    private int maxSize;
    public int[] stackArray;
    private int top;

    public Stack(int s) {
        maxSize = s;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int j) {
        stackArray[++top] = j;
    }
    public int pop() {
        return stackArray[top--];
    }
    public int peek() {
        return stackArray[top];
    }
    public boolean isEmpty() {
        return (top == -1);
    }
    public boolean isFull() {
        return (top == maxSize);
    }
}