import java.util.Scanner;

public class StudentResult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input student ID
        System.out.print("Student ID: ");
        String studentID = sc.nextLine();

        // Input number of courses
        System.out.print("No. of Courses: ");
        int n = sc.nextInt();

        double totalCreditTaken = 0;
        double totalWeightedGradePoint = 0;
        double totalCreditEarned = 0;

        for (int i = 1; i <= n; i++) {
            System.out.println("\nCourse " + i + ":");
            System.out.print("Credit (Max 3): ");
            double credit = sc.nextDouble();

            System.out.print("CT (Max 30): ");
            double ct = sc.nextDouble();

            System.out.print("AT (Max 10): ");
            double at = sc.nextDouble();

            System.out.print("FE (Max 60): ");
            double fe = sc.nextDouble();

            double total = ct + at + fe;
            double gradePoint = calculateGradePoint(total);
            boolean passed = total >= 40; // Assume passing mark is 40

            totalCreditTaken += credit;
            if (passed) {
                totalCreditEarned += credit;
                totalWeightedGradePoint += (gradePoint * credit);
            }
        }

        double cgpa = totalWeightedGradePoint / totalCreditTaken;
        String grade = getLetterGrade(cgpa);

        // Output
        System.out.println("\n--- RESULT ---");
        System.out.println("Student ID: " + studentID);
        System.out.println("Credit Taken: " + totalCreditTaken);
        System.out.println("Credit Earned: " + totalCreditEarned);
        System.out.printf("CGPA: %.2f\n", cgpa);
        System.out.println("Grade: " + grade);

        sc.close();
    }

    // Method to calculate grade point from total marks
    public static double calculateGradePoint(double marks) {
        if (marks >= 80) return 4.0;
        else if (marks >= 75) return 3.75;
        else if (marks >= 70) return 3.5;
        else if (marks >= 65) return 3.25;
        else if (marks >= 60) return 3.0;
        else if (marks >= 55) return 2.75;
        else if (marks >= 50) return 2.5;
        else if (marks >= 45) return 2.25;
        else if (marks >= 40) return 2.0;
        else return 0.0;
    }

    // Method to get final letter grade from CGPA
    public static String getLetterGrade(double cgpa) {
        if (cgpa >= 4.0) return "A+";
        else if (cgpa >= 3.75) return "A";
        else if (cgpa >= 3.5) return "A-";
        else if (cgpa >= 3.25) return "B+";
        else if (cgpa >= 3.0) return "B";
        else if (cgpa >= 2.75) return "B-";
        else if (cgpa >= 2.5) return "C+";
        else if (cgpa >= 2.25) return "C";
        else if (cgpa >= 2.0) return "D";
        else return "F";
    }
}
