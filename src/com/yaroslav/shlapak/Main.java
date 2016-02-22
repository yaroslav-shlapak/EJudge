package com.yaroslav.shlapak;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner scanner = new Scanner(System.in);
        int eid,sid;
        String ename;
        System.out.println("Enter Employeeid:");
        eid=scanner.nextInt();
        scanner.nextLine(); //This is needed to pick up the new line
        System.out.println("Enter EmployeeName:");
        ename=scanner.nextLine();
        System.out.println("Enter SupervisiorId:");
        sid=(scanner.nextInt());
    }
}
