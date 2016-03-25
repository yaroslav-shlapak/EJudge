//package com.yaroslav.shlapak;

import java.util.Scanner;

/**
 * Created by y.shlapak on Mar 25, 2016.
 */
public class Robots1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();

        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        if(x1 == x2) {
            if (y1 == y2) {
                System.out.println(0);
                return;
            }
        }

        if(x1 == x2) {
            int res = y1 > y2 ? y1 - y2 : y2 - y1;
            System.out.println(--res);
            return;
        }

        if(y1 == y2) {
            int res = x1 > x2 ? x1 - x2 : x2 - x1;
            System.out.println(--res);
            return;
        }

        int x = x1 > x2 ? x1 - x2 : x2 - x1;
        int y = y1 > y2 ? y1 - y2 : y2 - y1;
        if(x == y) {
            System.out.println(--x);
            return;
        }



        int maxX = x1 > x2 ? x1 : x2;
        int maxY = y1 > y2 ? y1 : y2;
        int minX = x1 < x2 ? x1 : x2;
        int minY = y1 < y2 ? y1 : y2;

        int dx = maxX - minX;
        int dy = maxY - minY;

        //System.out.println(dx);
        //System.out.println(dy);
        int min = dx < dy ? dx : dy;
        int maxDiv = 0;
        for(int i = min; i >= 1; i--) {
            if((dx % i) == 0 && (dy % i) == 0) {
                maxDiv = i;
                break;
            }
        }
        //System.out.println(maxDiv);
        if(maxDiv == 0 || maxDiv == 1) {
            System.out.println(0);
            return;
        }



        int xStep = dx / maxDiv;
        int xx = minX;
        int count = 0;
        while(true) {
            xx += xStep;
            if(xx < maxX) {
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);



        /*

        if(x1 == x2) {
            int res = y1 > y2 ? y1 - y2 : y2 - y1;
            System.out.println(--res);
            return;
        }

        if(y1 == y2) {
            int res = x1 > x2 ? x1 - x2 : x2 - x1;
            System.out.println(--res);
            return;
        }

        int x = x1 > x2 ? x1 - x2 : x2 - x1;
        int y = y1 > y2 ? y1 - y2 : y2 - y1;
        if(x == y) {
            System.out.println(--x);
            return;
        } else {
            int res = 0;
            while(x % 2 == 0 && y % 2 == 0) {
                res++;
                x /= 2;
                y /= 2;
            }
            res = (int) Math.pow(res, 2) - 1;
            System.out.println(res);
        }*/
        /*
        int xMax = x1 > x2 ? x1 : x2;
        int yMax = y1 > y2 ? y1 : y2;
        int xMin = x1 < x2 ? x1 : x2;
        int yMin = y1 < y2 ? y1 : y2;
        int res = 0;
        for(int xx = xMin + 1; xx < xMax; xx++) {
            for(int yy = yMin + 1; yy < yMax; yy++) {
                int a = y1 - y2;
                int b = x2 - x1;
                int c = x1 * y2 - x2 * y1;
                if((a * xx + b * yy + c) == 0) {
                    res++;
                }
            }
        }
        System.out.println(res);*/
    }

}
