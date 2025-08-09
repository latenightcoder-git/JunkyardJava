// Importing exception to handle stack underflow scenarios
import java.util.EmptyStackException;

public class StudentStack {
    // Array to hold StudentRecord objects
    private StudentRecord[] stack;
    // Index of the top element in the stack
    private int top;

    //Constructor to initialize the stack with a given capacity.
    public StudentStack(int capacity) {
        stack = new StudentRecord[capacity];
        top = -1;
        System.out.println("Initialized stack for " + capacity + " students.");
    }

    //Checks if the stack is Empty
    public boolean isEmpty() {
        return top == -1;
    }

    //Checks if the stack is Full
    public boolean isFull() {
        return top == stack.length - 1;
    }

    //Pushes a StudentRecord onto the stack.
    //If the stack is full, prints an overflow message.
    public void push(StudentRecord student) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push.");
            return;
        }
        stack[++top] = student;
        System.out.println("Student pushed: " + student);
    }

    /**
     * Pops the top StudentRecord from the stack.
     * @return The student record removed from the top
     * @throws EmptyStackException if the stack is empty
     */
    public StudentRecord pop() {
        if (isEmpty()) {
            System.out.println("The stack is empty...Stack Underflow");
            throw new EmptyStackException();
        }
        return stack[top--];
    }

    /**
     * Peeks at the top StudentRecord without removing it.
     * @return The student record at the top
     * @throws EmptyStackException if the stack is empty
     */
    public StudentRecord peek() {
        if (isEmpty()) {
            System.out.println("The stack is empty...Stack Underflow");
            throw new EmptyStackException();
        }
        return stack[top];
    }

    /**
     * Returns the current number of elements in the stack.
     * @return Stack size
     */
    public int size() {
        return top + 1;
    }

    /**
     * Displays all student records in the stack from top to bottom.
     */
    public void displayAll() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("----- Student Stack -----");
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    /**
     * Searches for a student by email.
     * @param email The email to search for
     */
    public void searchByEmail(String email) {
        boolean found = false;
        for (int i = top; i >= 0; i--) {
            if (stack[i].getEmail().equalsIgnoreCase(email)) {
                System.out.println("Found by email: " + stack[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with email: " + email);
        }
    }

    /**
     * Searches for a student by name.
     * @param name The name to search for
     */
    public void searchByName(String name) {
        boolean found = false;
        for (int i = top; i >= 0; i--) {
            if (stack[i].getName().equalsIgnoreCase(name)) {
                System.out.println("Found by name: " + stack[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with name: " + name);
        }
    }
}
