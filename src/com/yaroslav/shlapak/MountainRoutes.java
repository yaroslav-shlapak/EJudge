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

        System.out.println(depthFirstSearch(n, a, b, d, routes));
    }

    public static int depthFirstSearch(int n, int a, int b, int d, int[][] routes) {

        /*for(int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(routes[i]));
        }*/

        Stack routesStack = new Stack(100);
        Stack daysStack = new Stack(100);
        routesStack.push(a);

        int numberOfDays = 0;
        int counter = 0;
        daysStack.push(numberOfDays);
        int[] visited = new int[n];
        while (!routesStack.isEmpty()) {

            //routesStack.display();
            int currentHostel = routesStack.pop();
            //System.out.println("currentHostel = " + currentHostel);
            numberOfDays = daysStack.pop();
            int stackSize = routesStack.getSize();
            //System.out.println("numberOfDays = " + numberOfDays);
            if(numberOfDays <= d) {
                if (currentHostel == b) {
                    counter++;
                    //visited = new int[n];
                    //System.out.println("counter = " + counter);
                } else {
                    for (int i = 0; i < n; i++) {
                        if (routes[currentHostel - 1][i] == 1 && visited[i] == 0) {
                            routesStack.push(i + 1);
                            daysStack.push(numberOfDays + 1);
                        }
                    }
                    if(stackSize == routesStack.getSize()) {
                        visited[currentHostel - 1] = 1;
                        System.out.println(currentHostel);
                    }

                }
            }

        }

        return counter;
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
    public void display() {
        for(int i = 0; i <= top; i++) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
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

    public int getSize() {
        return top;
    }
}