package com.yaroslav.shlapak;

import java.util.Scanner;

/**
 * Created by y.shlapak on Apr 05, 2016.
 */

/*
7 3
---X--X
-X--XX-
*/

public class JumpingOnWalls {
    static int n, k;
    static int[][] tunnel;
    static int[][] tunnelClone;
    static int waterLevel = 0;
    static boolean done = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        k = scanner.nextInt();

        tunnel = new int[n + k + 1][2];
        tunnelClone = new int[n + k + 1][2];

        String leftString = scanner.next();
        String rightString = scanner.next();

        for(int i = 0; i < leftString.length(); i++) {
            tunnel[i][0] = leftString.charAt(i) == 'X' ? 1 : 0;
            tunnel[i][1] = rightString.charAt(i) == 'X' ? 1 : 0;
            //tunnelClone[i][0] = n + 1;
            //tunnelClone[i][1] = n + 1;
        }

        /*
        for(int i = 0; i < n; i++) {
            System.out.print("" + tunnel[i][0]);
        }
        System.out.println();
        for(int i = 0; i < n; i++) {
            System.out.print("" + tunnel[i][1]);
        }
        System.out.println();
        */

        int level = 0;
        int waterLevel = 0;
        int side = 0; //left
        /*int[] temp;
        Queue queue = new Queue(n * 2);
        moveQueue(level, waterLevel, side, queue);
        while(!queue.isEmpty()) {
            if(done) {
                break;
            }
            temp = queue.pop();

            level = temp[0];
            side = temp[1];
            waterLevel = temp[2];

            moveQueue(level, side, waterLevel, queue);
        }*/



        move(level, side, waterLevel);
        if(done) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }


    private static void moveQueue(int level, int side, int waterLevel, Queue queue) {
        //System.out.println("" + level + " " + side);
        if(done) {
            return;
        }

        if(level + k > n ) {
            done = true;
            return;
        }

        if(tunnel[level + k][side == 0 ? 1 : 0] == 0 && tunnelClone[level + k][side == 0 ? 1 : 0] == 0) {
            tunnelClone[level + k][side == 0 ? 1 : 0] = 1;
            queue.push(level + k, side == 0 ? 1 : 0, waterLevel + 1);
        }

        if(tunnel[level + 1][side] == 0 && tunnelClone[level + 1][side] == 0) {
            tunnelClone[level + 1][side] = 1;
            queue.push(level + 1, side, waterLevel + 1);
        }

        if(level > 0 && tunnel[level - 1][side] == 0 && waterLevel + 1 <= level - 1 && tunnelClone[level - 1][side] == 0) {
            tunnelClone[level - 1][side] = 1;
            queue.push(level - 1, side, waterLevel + 1);
        }
    }


    private static void move(int level, int side, int waterLevel) {
        //System.out.println("" + level + " " + side);
        if(done) {
            return;
        }

        if(level + k > n ) {
            done = true;
            return;
        }

        if(tunnel[level + k][side == 0 ? 1 : 0] == 0 && tunnelClone[level + k][side == 0 ? 1 : 0] == 0) {
            tunnelClone[level + k][side == 0 ? 1 : 0] = 1;
            move(level + k, side == 0 ? 1 : 0, waterLevel + 1);
        }

        if(tunnel[level + 1][side] == 0 && tunnelClone[level + 1][side] == 0) {
            tunnelClone[level + 1][side] = 1;
            move(level + 1, side, waterLevel + 1);
        }

        if(level > 0 && tunnel[level - 1][side] == 0 && waterLevel + 1 <= level - 1 && tunnelClone[level - 1][side] == 0) {
            tunnelClone[level - 1][side] = 1;
            move(level - 1, side, waterLevel + 1);
        }

    }

    private static class Queue {
        private int size;
        private int front;
        private int back;
        private int[][] queue;

        public Queue(int size) {
            this.size = size;
            queue = new int[size][3];
            front = back = 0;
        }

        public void push(int level, int side, int waterLevel) {
            if(back < size) {
                queue[back][0] = level;
                queue[back][1] = side;
                queue[back][2] = waterLevel;
                back++;
            }
        }

        public int[] pop() {
            if(front <= back) {
                return queue[front++];
            } else {
                return new int[]{-1, -1, -1};
            }
        }

        public int getSize() {
            return this.size;
        }

        public  boolean isEmpty() {
            return front == back;
        }
    }

}
