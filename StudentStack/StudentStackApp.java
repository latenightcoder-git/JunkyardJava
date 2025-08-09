import java.util.Scanner;
import java.util.EmptyStackException;

/**
 * Main application class to interact with the StudentStack.
 * Provides a menu-driven interface for stack operations.
 */
public class StudentStackApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentStack studentStack = new StudentStack(10); 

        int choice; // Variable to store user's menu selection

        // Menu loop continues until user chooses to exit

        do {
            // Displaying the menu options
            System.out.println("\n===== Student Stack Menu =====");
            System.out.println("1. Push student");
            System.out.println("2. Pop student");
            System.out.println("3. Peek top student");
            System.out.println("4. Display all students");
            System.out.println("5. Stack size");
            System.out.println("6. Search by email");
            System.out.println("7. Search by name");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    // Collecting student details from user
                    System.out.print("Enter roll number: ");
                    int roll = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    // Creating a new StudentRecord and pushing it onto the stack
                    StudentRecord student = new StudentRecord(roll, name, email);
                    studentStack.push(student);
                    break;

                case 2:
                    // Attempting to pop the top student from the stack
                    try {
                        StudentRecord removed = studentStack.pop();
                        System.out.println("Popped student: " + removed);
                    } catch (EmptyStackException e) {
                        System.out.println("Stack is empty. Cannot pop.");
                    }
                    break;

                case 3:
                    // Attempting to peek at the top student without removing
                    try {
                        StudentRecord top = studentStack.peek();
                        System.out.println("Top student: " + top);
                    } catch (EmptyStackException e) {
                        System.out.println("Stack is empty.");
                    }
                    break;

                case 4:
                    // Displaying all students currently in the stack
                    studentStack.displayAll();
                    break;

                case 5:
                    // Showing the current number of students in the stack
                    System.out.println("Current stack size: " + studentStack.size());
                    break;

                case 6:
                    // Searching for a student by email
                    System.out.print("Enter email to search: ");
                    String searchEmail = scanner.nextLine();
                    studentStack.searchByEmail(searchEmail);
                    break;

                case 7:
                    // Searching for a student by name
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    studentStack.searchByName(searchName);
                    break;

                case 8:
                    // Exiting the program
                    System.out.println("Exiting program.");
                    break;

                default:
                    // Handling invalid menu choices
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 8); // Loop continues until user selects Exit

        // Closing the scanner to free resources
        scanner.close();
    }
}
