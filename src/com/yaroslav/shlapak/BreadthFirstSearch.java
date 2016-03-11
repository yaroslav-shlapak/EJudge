package com.yaroslav.shlapak;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by y.shlapak on Mar 11, 2016.
 */
/*
4 4 3
0 1 1 1
1 0 1 0
1 1 0 0
1 0 0 0
*/
public class BreadthFirstSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int f = scanner.nextInt();

        int[][] adjacencyMatrix = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
            System.out.println(Arrays.toString(adjacencyMatrix[i]));
        }

        Queue queue = new Queue(100);

        queue.enqueue(3);

        while(!queue.isEmpty()) {
            int current = queue.dequeue();

            for(int i = 0; i < n; i++) {
                if(adjacencyMatrix[current][i] == 1) {
                    queue.enqueue(i + 1);
                }
            }


        }

    }
}

class Queue{
    private int size;
    private int front;
    private int back;
    private int[] queue;

    public Queue(int size) {
        this.size = size;
        queue = new int[size];
        front = 0;
        back = 0;
    }

    public void enqueue(int x) {
        if(front <= size) {
            queue[front++]=x;
        }
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


}