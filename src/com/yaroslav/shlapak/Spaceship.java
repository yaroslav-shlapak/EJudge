//package com.yaroslav.shlapak;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by y.shlapak on Apr 11, 2016.
 */
public class Spaceship {
    private static int[][][] field = new int[101][101][6];
    private static int[][][] visited = new int[101][101][7];
    private static int[][] portals;
    private static int startX, startY, endX, endY, numberOfPortals, minLength;
    private static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        startX = scanner.nextInt();
        startY = scanner.nextInt();
        endX = scanner.nextInt();
        endY = scanner.nextInt();

        minLength = getDistance(startX, startY, endX, endY);
        numberOfPortals = scanner.nextInt();
        portals = new int[numberOfPortals + 1][5];

        for(int i = 1; i < numberOfPortals + 1; i++) {
            for(int j = 0; j < 5; j++) {
                portals[i][j] = scanner.nextInt();
            }
            int tempPortalIndex1 = field[portals[i][1]][portals[i][0]][0];
            int tempPortalIndex2 = field[portals[i][3]][portals[i][2]][0];

            field[portals[i][1]][portals[i][0]][tempPortalIndex1 + 1] = i;
            field[portals[i][3]][portals[i][2]][tempPortalIndex2 + 1] = i;
            field[portals[i][1]][portals[i][0]][0] = tempPortalIndex1 + 1;
            field[portals[i][3]][portals[i][2]][0] = tempPortalIndex2 + 1;
        }

        Queue queue = new Queue(11000);
        visited[startY][startX][0] = 1;
        queue.push(startX, startY, 0, 0);
        int x, y, distance, portal;
        int[] temp;
        while(!queue.isEmpty()) {
            temp = queue.pop();
            x = temp[0];
            y = temp[1];
            distance = temp[2];
            portal = temp[3];

            moveQueue(x, y, distance, portal, queue);
        }
        System.out.println(minLength);
    }

    static void moveQueue(int x, int y, int distance, int portal, Queue queue) {
        /*if(distance > minLength) {
            return;
        }*/
        if(x == endX && y == endY && minLength > distance) {
            minLength = distance;
            return;
        }
        int xx, yy;
        for(int i = 0; i < moves.length; i++) {
            xx = x + moves[i][0];
            yy = y + moves[i][1];
            if(xx > 0 && xx < 101 && yy > 0 && yy < 101) {
                if(visited[yy][xx][0] == 0 && distance + 1 <= minLength) {
                    visited[yy][xx][0] = distance + 1;
                    queue.push(xx, yy, distance + 1, portal);
                }
            }
        }
        int size = field[y][x][0];
        if (size != 0) {
            for(int i = 1; i < size + 1; i++) {
                int index = field[y][x][i];

                int tempDist = distance + portals[index][4];

                if (portals[index][0] == x && portals[index][1] == y) {
                    xx = portals[index][2];
                    yy = portals[index][3];
                } else {
                    xx = portals[index][0];
                    yy = portals[index][1];
                }
                if (tempDist <= minLength && visited[yy][xx][0] <= tempDist) {
                    visited[yy][xx][0] = tempDist;
                    queue.push(xx, yy, tempDist, index);
                        /*visited[yy][xx] = 1;*/
                }

            }
        }
    }

    static int getDistance(int startX, int startY, int endX, int endY) {
        return (endX > startX ? endX - startX : startX - endX) +
                (endY > startY ? endY - startY : startY - endY);
    }


    private static class Queue {
        private int size;
        private int front;
        private int back;
        private int[][] queue;

        public Queue(int size) {
            this.size = size;
            queue = new int[size][4];
            front = back = 0;
        }

        public void push(int x, int y, int distance, int portal) {
            if(back < size) {
                queue[back][0] = x;
                queue[back][1] = y;
                queue[back][2] = distance;
                queue[back][3] = portal;
                back++;
            }
        }

        public int[] pop() {
            if(front <= back) {
                return queue[front++];
            } else {
                return new int[]{-1, -1, -1, -1};
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
