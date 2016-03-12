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
/*
7 7 3
0 1 1 1 0 0 0
1 0 1 0 0 0 0
1 1 0 0 0 0 0
1 0 0 0 1 0 0
0 0 0 1 0 1 0
0 0 0 0 1 0 1
0 0 0 0 0 1 0
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
            //System.out.println(Arrays.toString(adjacencyMatrix[i]));
        }



        System.out.println(breadthFirstSearch(adjacencyMatrix, n, s, f));

    }

    public static int breadthFirstSearch(int[][] adjacencyMatrix, int n, int s, int f) {
        Queue queue = new Queue(1000);
        Queue len = new Queue(1000);
        int[] used = new int[n];
        if(s == f)
            return 0;

        queue.enqueue(s);
        int result = 0;
        len.enqueue(1);
        while(!queue.isEmpty()) {

            int current = queue.dequeue();
            int currentCounter = len.dequeue();

            if(used[current - 1] == 1) {
                continue;
            }
            for(int i = 0; i < n; i++) {
                if(adjacencyMatrix[current - 1][i] == 1) {
                    if(i + 1  == f) {
                        result = currentCounter;
                        return result;
                    }
                    queue.enqueue(i + 1);
                    len.enqueue(currentCounter + 1);
                    //queue.display();
                }
            }
            used[current - 1] = 1;

        }
        return result;
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

    public void display() {
        for(int i = back; i < front; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return front == back;
    }


}