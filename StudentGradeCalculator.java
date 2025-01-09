//STUDENT GRADE CALCULATOR
/*
Input: Take marks obtained (out of 100) in each subject.
Calculate Total Marks: Sum up the marks obtained in all subjects.
Calculate Average Percentage: Divide the total marks by the total number of subjects to get the
average percentage.
Grade Calculation: Assign grades based on the average percentage achieved.
Display Results: Show the total marks, average percentage, and the corresponding grade to the user
*/

class StudentGradeCalculator {
    public static void main(String[] args) {
        displayResults(args);
    }

    static void displayResults(String[] args) {
        // Check if arguments are provided
        if (args.length == 0) {
            System.out.println("Enter at least marks of one subject.");
            return;
        }

        int totalMarks = 0;
        int numberOfSubjects = args.length;

        // Validate and calculate total marks
        for (int i = 0; i < args.length; i++) {
            int marks = Integer.parseInt(args[i]);
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid mark entered: " + marks + ". Marks should be between 0 and 100.");
                return;
            }
            totalMarks += marks;
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;

		//Calculating Full Marks based on Number of subjects 
		int FullMarks = numberOfSubjects*100;
		
        // Display total marks upon full marks 
        System.out.println("Total Marks Achieved upon Full Marks " + totalMarks + "/" +FullMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);

        // Determine grade based on the average percentage
        char grade;
        if (averagePercentage >= 90 && averagePercentage <= 100) {
            grade = 'O';
			System.out.println("Outstanding");
        } else if (averagePercentage >= 80 && averagePercentage < 90) {
            grade = 'E';
			System.out.println("Excellent");
        } else if (averagePercentage >= 70 && averagePercentage < 80) {
            grade = 'A';
        } else if (averagePercentage >= 60 && averagePercentage < 70) {
            grade = 'B';
        } else if (averagePercentage >= 50 && averagePercentage < 60) {
            grade = 'C';
        } else if (averagePercentage >= 40 && averagePercentage < 50){
            grade = 'D';
        }
		else {
			grade = 'F';
		}

        // Display grade
        System.out.println("Grade: " + grade);
    }
}
