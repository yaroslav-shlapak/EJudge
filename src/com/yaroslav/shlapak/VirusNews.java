//package com.yaroslav.shlapak;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yarl on 23.02.16.
 */
public class VirusNews {
    public static void main(String[] args) {
        // write your code here

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        if(n < 1) {
            System.out.println(0);
            return;
        } else if(n > 1000) {
            n = 1000;
        }


        QuickUnionUF qf = new QuickUnionUF(n);

        int ans = n;

        int current;
        int data[][] = new int[n][n];
        int[] id = new int[n];

        for(int i = 0; i < n; i++) {
            id[i] = i;
        }
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                data[i][j] = scanner.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                current = data[i][j];
                if(current == 1 && data[i][j] == data[j][i]) {
                    qf.union(i, j);
                }
                /*current = data[i][j];
                if(current == 1 && data[i][j] == data[j][i]) {
                    if (id[i] == i) {
                        if (id[j] == j) {
                            id[j] = id[i];
                        } else {
                            id[i] = id[j];
                        }
                    } else {
                        id[j] = id[i];
                    }
                    //System.out.println(Arrays.toString(id));
                }*/
            }
        }
        //System.out.println(Arrays.toString(id));

        for(int i = 0; i < n; i++) {
            if(qf.id[i] != i) {
                ans--;
            }
        }
        System.out.println(ans);

    }
}

class QuickUnionUF {
    public int[] id;
    private int[] sz;

    public QuickUnionUF(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public void printId() {
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + " ");
        }
        System.out.println();
    }

    private int root(int i) {
        while (i != id[i]) {
            //id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        //id[i] = j;
        if (i == j) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        //printId();
    }
}

