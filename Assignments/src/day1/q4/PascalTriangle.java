package day1.q4;

/*
Q4. Create pascal triangle using 2D arrary
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
1 2 3 4 5 6
1 2 3 4 5 6 7
1 2 3 4 5 6 7 8
 */

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number of Rows: ");
        int n = scanner.nextInt();
        //int n = 8; // Number of rows
        int[][] pascal = new int[n][n];
        for (int i = 0; i < n; i++) {
            pascal[i][0] = 1;
            pascal[i][i] = 1;
        }

        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(pascal[i][j] + " ");
            }
            System.out.println();
        }
    }
}
