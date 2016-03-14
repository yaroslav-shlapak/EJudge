package com.yaroslav.shlapak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yaroslav on 3/13/16.
 */
public class ShortestPath {
    static final int MAX_N = 50000;
    static final int MAX_M = 100000;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // vertice
        int m = scanner.nextInt(); // edge

        int a = scanner.nextInt(); // start
        int b = scanner.nextInt(); // finish


        int[][] adjacencyList = new int[n + 1][n + 1];
        int[] size = new int[n + 1];

        for(int i = 0; i < m; i++) {
            int horz = scanner.nextInt() - 1;
            int vert = scanner.nextInt() - 1;
            adjacencyList[horz][size[horz]++] = vert + 1;
            adjacencyList[vert][size[vert]++] = horz + 1;
        }
        breadthFirstSearch(n, a, b, adjacencyList, size);
    }

    private static void breadthFirstSearch(int n, int a, int b, int[][] adjacencyList, int[] size) {
        int[] path = new int[n + 1];
        int[] shortestPath = new int[n + 1];
        int[] visited = new int[n + 1];
        int length = 0;

        boolean found = false;
        Queue verticeQueue = new Queue(n + 1);

        verticeQueue.enqueue(a);

        visited[a - 1] = 1;

        path[0] = a;
        path[a - 1] = a;
        while (!verticeQueue.isEmpty()) {
            //verticeQueue.display();
            int currentVertice = verticeQueue.dequeue();

            if(currentVertice == b) {
                found = true;
                int x = currentVertice;

                shortestPath[length] = x;

                while(x != a) {
                    x = path[x - 1];
                    shortestPath[++length] = x;
                }
                //System.out.println(length);
                //System.out.println(Arrays.toString(shortestPath));

                for(int j = 0; j < length  / 2; j++) {
                    int temp = shortestPath[length - j];
                    shortestPath[length - j] = shortestPath[j];
                    shortestPath[j] = temp;
                }
                //System.out.println(Arrays.toString(shortestPath));
                break;
            }

            for(int i = 0; i < size[currentVertice - 1]; i++) {
                int vertice = adjacencyList[currentVertice - 1][i];
                if(visited[vertice - 1] == 0) {
                    verticeQueue.enqueue(vertice);
                    visited[vertice - 1] = 1;
                    path[vertice  - 1] = currentVertice;
                }
            }
        }

        if(!found) {
            System.out.println(-1);
        } else {
            System.out.println(length);
            for(int i = 0; i < length + 1; i++) {
                System.out.print(shortestPath[i] + " ");
            }
        }

    }


    private static class Queue {
        private int front;
        private int back;
        private int size;
        private int[] queue;

        public Queue(int size) {
            this.size = size;
            queue = new int[size];
            back = 0;
            front = 0;
        }

        public void enqueue(int e) {
            if(front < size)
                queue[front++] = e;
        }

        public int dequeue() {
            if(!isEmpty())
                return queue[back++];
            else
                return -1;
        }

        public boolean isEmpty() {
            return front == back;
        }

        public void display() {
            for(int i = back; i < front; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }
}
