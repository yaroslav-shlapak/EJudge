//package com.yaroslav.shlapak;

import java.util.Scanner;

/**
 * Created by y.shlapak on Apr 12, 2016.
 */
public class SpaceShip2 {
    private static int[][] portals;
    private static int[][] visited;
    private static int startX, startY, endX, endY, numberOfPortals, minLength;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        startX = scanner.nextInt();
        startY = scanner.nextInt();
        endX = scanner.nextInt();
        endY = scanner.nextInt();

        minLength = getDistance(startX, startY, endX, endY);
        numberOfPortals = scanner.nextInt();
        portals = new int[numberOfPortals + 1][5];
        visited = new int[numberOfPortals + 1][2];

        for(int i = 0; i < numberOfPortals; i++) {
            for(int j = 0; j < 5; j++) {
                portals[i][j] = scanner.nextInt();
            }
        }

        move(startX, startY, 0);

        System.out.println(minLength);
    }

    static void move(int x, int y, int distance) {
        if (minLength > distance + getDistance(x, y, endX, endY)) {
            minLength = distance + getDistance(x, y, endX, endY);
            //System.out.println(minLength);
        }

        int xx, yy;
        for(int i = 0; i < numberOfPortals; i++) {
                //System.out.println(i);
                for (int j = 0; j < 2; j++) {
                    if (visited[i][j] == 0) {

                        xx = portals[i][0 + j * 2];
                        yy = portals[i][1 + j * 2];
                        int tempDistance = portals[i][4] + getDistance(x, y, xx, yy) + distance;
                        xx = portals[i][0 + 2 - j * 2];
                        yy = portals[i][1 + 2 - j * 2];

                        if(distance < minLength) {
                            visited[i][1 - j] = 1;
                            visited[i][j] = 1;
                            move(xx, yy, tempDistance);
                            //System.out.println("xx = " + xx + ", yy = " + yy + ", distance = " + tempDistance);
                            visited[i][1 - j] = 0;
                            visited[i][j] = 0;
                            //System.out.println("xx = " + xx + ", yy = " + yy);
                        }
                    }
                }
            }
        }

    static int getDistance(int startX, int startY, int endX, int endY) {
        return (endX > startX ? endX - startX : startX - endX) +
                (endY > startY ? endY - startY : startY - endY);
    }
}