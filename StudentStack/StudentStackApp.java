import java.util.Scanner;
import java.util.EmptyStackException;


public class StudentStackApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentStack studentStack = new StudentStack(10); // or dynamic size

        int choice;

        do {
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
                    System.out.print("Enter roll number: ");
                    int roll = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    StudentRecord student = new StudentRecord(roll, name, email);
                    studentStack.push(student);
                    break;

                case 2:
                    try {
                        StudentRecord removed = studentStack.pop();
                        System.out.println("Popped student: " + removed);
                    } catch (EmptyStackException e) {
                        System.out.println("Stack is empty. Cannot pop.");
                    }
                    break;

                case 3:
                    try {
                        StudentRecord top = studentStack.peek();
                        System.out.println("Top student: " + top);
                    } catch (EmptyStackException e) {
                        System.out.println("Stack is empty.");
                    }
                    break;

                case 4:
                    studentStack.displayAll();
                    break;

                case 5:
                    System.out.println("Current stack size: " + studentStack.size());
                    break;

                case 6:
                    System.out.print("Enter email to search: ");
                    String searchEmail = scanner.nextLine();
                    studentStack.searchByEmail(searchEmail);
                    break;

                case 7:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    studentStack.searchByName(searchName);
                    break;

                case 8:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 8);

        scanner.close();
    }
}
