/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentreport;

/**
 *
 * @author nivasharma
 * This Java program reads student data from a file named "student_data.txt" and calculates the average test grade for each student. 
 * It then determines the corresponding letter grade based on the average and prints the student name, average, and grade. 
 * Finally, it calculates and prints the overall average test grade for all students.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentReport {

    public static void main(String[] args) {
        String fileName = "student_data.txt";
        try {
            File inputFile = new File(fileName);
            Scanner input = new Scanner(inputFile);
            int numTests = input.nextInt();
            int count = 0;
            double totalAverages = 0.0;
            while (input.hasNext()) {
                String name = input.next();
                double sum = 0.0;
                for (int i = 0; i < numTests; i++) {
                    sum += input.nextDouble();
                }
                double average = studentAverage(sum, numTests);
                String grade = determineGrade(average);
                totalAverages += average;
                count++;
                System.out.printf("%-15s%-15.1f%s\n", name, average, grade);
            }
            double overallAverage = overallAverage(totalAverages, count);
            System.out.printf("\nThe average test grade is: %.1f\n", overallAverage);
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }

    public static double studentAverage(double sum, int numTests) {
        return sum / numTests;
    }

    public static String determineGrade(double average) {
        if (average >= 90.0) {
            return "A";
        } else if (average >= 80.0) {
            return "B";
        } else if (average >= 70.0) {
            return "C";
        } else if (average >= 60.0) {
            return "D";
        } else {
            return "F";
        }
    }

    public static double overallAverage(double totalAverages, int count) {
        return totalAverages / count;
    }
}
