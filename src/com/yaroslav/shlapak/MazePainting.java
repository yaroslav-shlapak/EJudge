package com.yaroslav.shlapak;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yarl on 15.03.16.
 */
public class MazePainting {
    public static final int ADD = 10;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] maze = new int[n + 2][n + 2];
        int[][] checked = new int[n + 2][n + 2];
        System.out.println(Arrays.toString(maze[0]));
        for(int i = 1; i <= n; i++) {

            String s = scanner.next();
            for(int j = 1; j <= n; j++) {
                maze[i][j] = convertSymbolToNumber(s.charAt(j - 1));
                checked[i][j] = 1;
            }
            System.out.println(Arrays.toString(maze[i]));
        }
        System.out.println(Arrays.toString(maze[n + 1]));

        System.out.println(breadthFirstSearch(n, maze, checked));


    }

    public static int breadthFirstSearch(int n, int[][] maze, int[][] checked) {
        Queue queue = new Queue(n + ADD);
        int segmentArea = 9;
        queue.push(1, 1);

        int[] neighbours = {1, -1};

        checked[1][1] = 0;
        int perimeter = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.pop();
            int y = current[0];
            int x = current[1];


            for(int i = 1; i <= n; i++) {
                if(checked[y][x] == 1 && maze[y][x] == 1) {
                    for (int yy : neighbours) {
                        for (int xx : neighbours) {
                            if (maze[y + yy][x + xx] == 0) {
                                if(!(y == n && x == n && xx == 1 &&  yy == 1)) {
                                    perimeter++;
                                }
                            }

                            if (maze[y + yy][x + xx] == 1) {
                                queue.push(y + yy, x + xx);
                            }
                        }
                    }
                }
                checked[y][x] = 0;
            }
        }

        return segmentArea * perimeter;
    }

    public static int convertSymbolToNumber(char symbol) {
        if(symbol == '#') {
            return 0;
        } else if(symbol == '.') {
            return 1;
        } else {
            return -1;
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

        public void push(int x, int y) {
            if(back <= size) {
                queue[front++][1] = x;
                queue[front++][0] = y;
            }
        }

        public int[] pop() {
            if(!isEmpty()) {
                return queue[back++];
            } else {
                return null;
            }
        }

        public boolean isEmpty() {
            return back == front;
        }
    }
}


