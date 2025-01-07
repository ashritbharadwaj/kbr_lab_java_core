package day1.q2;

/*
Q2. Write a program called GradesAverage, which prompts user for the number of students, reads it
from the keyboard, and saves it in an int variable called numStudents. It then prompts user for the
grades of each of the students and saves them in an int array called grades. Your program shall
check that the grade is between 0 and 100. A sample session is as follows:
Enter the number of students: 3
Enter the grade for student 1: 55
Enter the grade for student 2: 108
Invalid grade, try again...
Enter the grade for student 2: 56
Enter the grade for student 3: 57
The average is: 56.0
 */

import java.util.Scanner;

public class GradesAverage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        int[] g = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int grade;
            while (true) {
                System.out.print("Enter the grade for student " + (i + 1) + ": ");
                grade = scanner.nextInt();
                if (grade >= 0 && grade <= 100) {
                    break;
                } else {
                    System.out.println("Invalid grade, try again...");
                }
            }
            g[i] = grade;
            sum += grade;
        }

        double avg = (double) sum / n;
        System.out.println("The average is: " + avg);
    }
}
