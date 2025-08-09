import java.util.EmptyStackException;

public class StudentStack {
    private StudentRecord[] stack;
    private int top;

    public StudentStack(int capacity) {
        stack = new StudentRecord[capacity];
        top = -1;
        System.out.println("Initialized stack for " + capacity + " students.");
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stack.length - 1;
    }

    public void push(StudentRecord student) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push.");
            return;
        }
        stack[++top] = student;
        System.out.println("Student pushed: " + student);
    }

    public StudentRecord pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top--];
    }

    public StudentRecord peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top];
    }

    public int size() {
        return top + 1;
    }

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
