import java.util.*;

class parentheses {
    char[] stack;
    int top;
    int maxSize;

    parentheses(int size) {
        maxSize = size;
        stack = new char[maxSize];
        top = -1;
    }

    // Push character onto stack
    void push(char c) {
        if (top == maxSize - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = c;
    }

    // Pop character from stack
    char pop() {
        if (isEmpty()) {
            return '\0';
        }
        return stack[top--];
    }

    // Check if stack is empty
    boolean isEmpty() {
        return top == -1;
    }

    // Check if characters are matching pair
    boolean isMatchingPair(char open, char close) {
        if (open == '(' && close == ')') return true;
        if (open == '{' && close == '}') return true;
        if (open == '[' && close == ']') return true;
        return false;
    }

    // Check if parentheses are balanced
    boolean isBalanced(String expr) {
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            // If opening bracket, push to stack
            if (ch == '(' || ch == '{' || ch == '[') {
                push(ch);
            }

            // If closing bracket
            if (ch == ')' || ch == '}' || ch == ']') {
                // If stack is empty, no matching opening bracket
                if (isEmpty()) {
                    return false;
                }

                // Pop and check if it matches
                char popped = pop();
                if (!isMatchingPair(popped, ch)) {
                    return false;
                }
            }
        }

        // If stack is empty, all brackets matched
        return isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== PARENTHESES MATCHING USING STACK (ARRAY) ===\n");

        while (true) {
            System.out.print("Enter expression (or 'exit' to quit): ");
            String expr = sc.nextLine();

            if (expr.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            }

            parentheses p = new parentheses(expr.length());

            if (p.isBalanced(expr)) {
                System.out.println("Result: BALANCED ✓");
            } else {
                System.out.println("Result: NOT BALANCED ✗");
            }
            System.out.println();
        }

        sc.close();
    }
}
