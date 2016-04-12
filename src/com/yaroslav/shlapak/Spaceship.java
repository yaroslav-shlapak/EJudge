//package com.yaroslav.shlapak;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by y.shlapak on Apr 11, 2016.
 */
public class Spaceship {
    private static int[][] field = new int[110][110];
    private static int[][] visited = new int[110][110];
    private static int[][] portals;
    private static int startX, startY, endX, endY, numberOfPortals, length, minLength;
    private static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        startX = scanner.nextInt();
        startY = scanner.nextInt();
        endX = scanner.nextInt();
        endY = scanner.nextInt();

        minLength = getDistance(startX, startY, endX, endY);
        //System.out.println(minLength);

        numberOfPortals = scanner.nextInt();

        portals = new int[numberOfPortals + 1][5];

        for(int i = 1; i < numberOfPortals + 1; i++) {
            for(int j = 0; j < 5; j++) {
                portals[i][j] = scanner.nextInt();
            }
            field[portals[i][1]][portals[i][0]] = i;
            field[portals[i][3]][portals[i][2]] = i;
        }

        Queue queue = new Queue(11000);
        visited[startY][startX] = 1;
        moveQueue(startX, startY, 0, queue);
        int x, y, distance;
        int[] temp;
        while(!queue.isEmpty()) {

            temp = queue.pop();

            x = temp[0];
            y = temp[1];
            if(x < 0 || y < 0) {
                break;
            }
            distance = temp[2];
            //System.out.println("x = " + x + ", y = " + y + ", distance = " + distance);
            moveQueue(x, y, distance, queue);
        }
        System.out.println(minLength);
    }

    static void moveQueue(int x, int y, int distance, Queue queue) {
        if(distance >= minLength) {
            return;
        }
        if(x == endX && y == endY && minLength > distance) {
            minLength = distance;
            //System.out.println(minLength);
            return;
        }
        //System.out.println("x = " + x + ", y = " + y + ", distance = " + distance);
        int xx, yy;
        for(int i = 0; i < moves.length; i++) {
            xx = x + moves[i][0];
            yy = y + moves[i][1];
            if(xx > 0 && xx < 101 && yy > 0 && yy < 101) {
                if(visited[yy][xx] == 0) {
                    visited[yy][xx] = 1;
                    queue.push(xx, yy, distance + 1);
                }
            }
        }
        int index = field[y][x];
        int tempDist = distance + portals[index][4];
        if(index != 0) {
            if(portals[index][0] == x && portals[index][1] == y) {
                xx = portals[index][2];
                yy = portals[index][3];
            } else {
                xx = portals[index][0];
                yy = portals[index][1];
            }

            if( tempDist  <= minLength && visited[yy][xx] == 0) {
                queue.push(xx, yy, tempDist);
                visited[yy][xx] = 1;
                //System.out.println("xx = " + xx + ", yy = " + yy + ", distance = " + tempDist);
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
            queue = new int[size][3];
            front = back = 0;
        }

        public void push(int x, int y, int distance) {
            if(back < size) {
                queue[back][0] = x;
                queue[back][1] = y;
                queue[back][2] = distance;
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
/*
    static void move(int x, int y, int distance) {
        if(distance >= minLength) {
            return;
        }
        if(x == endX && y == endY && minLength > distance) {
            minLength = distance;
            System.out.println(minLength);
            return;
        }
        //System.out.println("x = " + x + ", y = " + y + ", distance = " + distance);
        for(int i = 0; i < moves.length; i++) {
            int xx = x + moves[i][0];
            int yy = y + moves[i][1];
            if(xx > 0 && xx < 101 && yy > 0 && yy < 101) {
                if(visited[yy][xx] == 0) {
                    visited[yy][xx] = 1;
                    move(xx, yy, distance + 1);
                    int index = field[yy][xx];
                    if(index != 0) {
                        if(portals[index][0] == xx && portals[index][1] == yy) {
                            xx = portals[index][2];
                            yy = portals[index][3];
                            if(visited[yy][xx] == 0) {
                                visited[yy][xx] = 1;
                                move(xx, yy, distance + portals[index][4]);
                            }
                        } else {
                            xx = portals[index][0];
                            yy = portals[index][1];
                            if(visited[yy][xx] == 0) {
                                visited[yy][xx] = 1;
                                move(xx, yy, distance + portals[index][4]);
                            }
                        }
                        System.out.println("xx = " + xx + ", yy = " + yy + ", distance = " + distance);
                    }
                }

            }
        }
    }



    //Heap's Algorithm
    public static void permutate(int[] list, int n)
    {
        if(n == 1)
        {
            int x = startX;
            int y = startY;
            crawlPath(list, startX, startY, 0, 0);
        }
        else
        {
            for(int i = 0; i < n; i++)
            {
                permutate(list, n - 1);

                int j = ( n % 2 == 0 ) ? i : 0;

                int t = list[n - 1];
                list[n - 1] = list[j];
                list[j] = t;
            }
        }
    }

    public static int crawlPath(int[] path, int x, int y, int index, int distance) {
        int x1 = portals[path[index]][0];
        int y1 = portals[path[index]][1];
        int x2 = portals[path[index]][2];
        int y2 =  portals[path[index]][3];
        int dist1 = distance + portals[path[index]][5] + getDistance(x, y, x1, y1);
        int dist2 = distance + portals[path[index]][5] + getDistance(x, y, x2, y2);

        return 1;

    }*/


}
