import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of grades
        System.out.print("Enter the number of grades: ");
        int numGrades = scanner.nextInt();

        // Check if the number of grades is valid (greater than 0)
        if (numGrades <= 0) {
            System.out.println("Please enter a valid number of grades.");
            return;
        }

        // Create an array to store the grades
        double[] grades = new double[numGrades];

        // Input each grade
        for (int i = 0; i < numGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
        }

        // Calculate the average grade
        double sum = 0;
        for (int i = 0; i < numGrades; i++) {
            sum += grades[i];
        }
        double average = sum / numGrades;

        // Display the average grade
        System.out.println("Average grade: " + average);
    }
}
