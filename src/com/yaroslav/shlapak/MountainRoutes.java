package com.yaroslav.shlapak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by y.shlapak on Mar 04, 2016.
 */
public class MountainRoutes {
    static int counter = 0;
    static int numberOfDays = 0;
    static int[] visited;

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

        visited = new int[n];
        depthFirstSearch(n, a, b, d, routes);
        System.out.println(counter);
    }

    public static void depthFirstSearch(int n, int currentHostel, int b, int d, int[][] routes) {

        if (numberOfDays <= d) {
            visited[currentHostel - 1] = 1;
            System.out.println(currentHostel);
            if (currentHostel == b) {
                counter++;
            } else {
                for (int i = 0; i < n; i++) {
                    if (routes[currentHostel - 1][i] == 1) {
                        int v = i + 1;

                        if(visited[i] == 0){
                            numberOfDays++;
                            depthFirstSearch(n, v, b, d, routes);
                            numberOfDays--;
                            visited[i] = 0;
                        }
                    }
                }
            }
        }
    }

    public static void depthFirstSearchNonRecursive(int n, int currentHostel, int b, int d, int[][] routes) {
        Stack hotelStack = new Stack(1000);
        Stack daysStack = new Stack(1000);
        hotelStack.push(currentHostel);
        daysStack.push(numberOfDays);

        while (!hotelStack.isEmpty()) {
            currentHostel = hotelStack.pop();
            numberOfDays = daysStack.pop();

            if (numberOfDays <= d) {
                visited[currentHostel - 1] = 1;
                if (currentHostel == b) {
                    counter++;
                } else {
                    for (int i = 0; i < n; i++) {
                        if (routes[currentHostel - 1][i] == 1) {
                            int v = i + 1;
                            if (visited[i] == 0) {
                                numberOfDays++;
                                hotelStack.push(v);
                                daysStack.push(numberOfDays);
                                numberOfDays--;
                                visited[i] = 0;
                            }
                        }
                    }
                }
            }
        }

    }

    private static class Stack {
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
        public boolean isEmpty() {
            return (top == -1);
        }

        public int peek() {
            return stackArray[top];
        }
        public boolean isFull() {
            return (top == maxSize);
        }
        public int getSize() {
            return top;
        }
    }
}

