package com.yaroslav.shlapak;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yarl on 15.03.16.
 */
/*
5
.....
...##
..#..
..###
.....
 */
public class MazePainting {
    public static final int ADD = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] maze = new int[n + 2][n + 2];
        int[][] checked = new int[n + 2][n + 2];
        //System.out.println(Arrays.toString(checked[0]));
        for(int i = 1; i <= n; i++) {

            String s = scanner.next();
            for(int j = 1; j <= n; j++) {
                maze[i][j] = convertSymbolToNumber(s.charAt(j - 1));
                checked[i][j] = 1;
            }
           // System.out.println(Arrays.toString(checked[i]));
        }
       // System.out.println(Arrays.toString(checked[n + 1]));

        System.out.println(breadthFirstSearch(n, maze, checked));


    }

    public static int breadthFirstSearch(int n, int[][] maze, int[][] checked) {
        int len  = n + ADD;
        len *= len;
        Queue queue = new Queue(len);
        boolean isLastFound = false;
        int segmentArea = 9;
        if(maze[1][1] == 0) {
            return 0;
        }
        queue.push(1, 1);

        int[] xn = {1, -1, 0, 0};
        int[] yn = {0, 0, 1, -1};

        int perimeter = 0;
        perimeter = bfsLoop(perimeter, queue, isLastFound,  maze, checked, xn, yn, n);
        if(!isLastFound) {
            queue.push(n, n);
            perimeter = bfsLoop(perimeter, queue, isLastFound,  maze, checked, xn, yn, n);
        }

        return segmentArea * perimeter;
    }

    public static int bfsLoop(int perimeter, Queue queue, boolean isLastFound, int[][] maze, int[][] checked, int[] xn, int[] yn, int n) {
        while (!queue.isEmpty()) {
            int[] current = queue.pop();
            int y = current[0];
            int x = current[1];
            //System.out.println("x = " + x + ", y = " + y);

            if(y == n && x == n) {
                isLastFound = true;
            }
            if (checked[y][x] == 1) {
                for (int j = 0; j < 4; j++ ) {
                    int xx = xn[j];
                    int yy = yn[j];
                    if (maze[y + yy][x + xx] == 0) {
                        if (!(((y == n && x == n) && (xx == 1 || yy == 1)) || ((y == 1 && x == 1) && (xx ==  -1 || yy == -1)))) {
                            perimeter++;
                            //System.out.println(perimeter);
                        }
                    }
                    if (checked[y + yy][x + xx] == 1 && maze[y + yy][x + xx] == 1) {
                        //System.out.println("x + xx = " + (x + xx) + ", y + yy = " + (y + yy));
                        queue.push(y + yy, x + xx);
                    }
                }
                checked[y][x] = 0;
            }
        }
        return perimeter;
    }

    public static int convertSymbolToNumber(char symbol) {
        if(symbol == '#') {
            return 0;
        } else if(symbol == '.') {
            return 1;
        } else {
            return 1;
        }
    }

    private static class Queue {
        private int size;
        private int front;
        private int back;
        private int[][] queue;

        public Queue(int size) {
            this.size = size;
            queue = new int[size][2];
            front = 0;
            back = 0;
        }

        public void push(int y, int x) {
            if(back <= size) {
                queue[front][1] = x;
                queue[front][0] = y;
                front++;
            }
        }

        public int[] pop() {
            if(!isEmpty()) {
                return queue[back++];
            } else {
                return new int[]{0, 0};
            }
        }

        public boolean isEmpty() {
            return back == front;
        }
    }
}


