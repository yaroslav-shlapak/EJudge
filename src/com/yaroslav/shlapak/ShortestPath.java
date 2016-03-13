package com.yaroslav.shlapak;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.jar.Pack200;

/**
 * Created by yaroslav on 3/13/16.
 */
public class ShortestPath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // vertice
        int m = scanner.nextInt(); // edge

        int a = scanner.nextInt(); // start
        int b = scanner.nextInt(); // finish

        int[][] adjacencyMatrix = new  int[n][n];
        ArrayList<Integer>[] adjacencyList = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adjacencyList[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            int horz = scanner.nextInt() - 1;
            int vert = scanner.nextInt();
            adjacencyList[horz].add(vert);
            //adjacencyList[vert].add(horz);
        }
        breadthFirstSearch(n, a, b, adjacencyList);
    }

    private static void breadthFirstSearch(int n, int a, int b, ArrayList<Integer>[] adjacencyList) {
        int[] path = new int[n * n];
        int[] visited = new int[n];
        int length = 0;
        boolean found = false;
        Queue verticeQueue = new Queue(1000);

        verticeQueue.enqueue(a);

        visited[a - 1] = 1;

        path[length] = a;
        while (!verticeQueue.isEmpty()) {
            verticeQueue.display();
            int currentVertice = verticeQueue.dequeue();
            System.out.println("currentVertice = " + currentVertice);
            //int currentLength = lengthQueue.dequeue();

            if(currentVertice == b) {
                found = true;
                break;
            }
            for(int i : adjacencyList[currentVertice - 1]) {
                System.out.println("i = "  + i);
                if(visited[i] == 0) {
                    verticeQueue.enqueue(i);
                    path[++length] = i;
                    visited[i - 1] = 1;
                }
            }
        }




        if(!found) {
            System.out.println(-1);
        } else {
            System.out.println(length);
            for(int i = 0; i < length; i++) {
                System.out.print(path[i] + " ");
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
