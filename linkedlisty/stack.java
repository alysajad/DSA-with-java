import java.util.*;

class stack {
    Node top;
    int size;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    stack() {
        top = null;
        size = 0;
    }

    // Push - Insert at top (head)
    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println("Pushed: " + data);
    }

    // Pop - Remove from top
    int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Stack is empty");
            return -1;
        }
        int popped = top.data;
        top = top.next;
        size--;
        System.out.println("Popped: " + popped);
        return popped;
    }

    // Peek - View top element without removing
    int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    // Check if stack is empty
    boolean isEmpty() {
        return top == null;
    }

    // Get size of stack
    int getSize() {
        return size;
    }

    // Display stack
    void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack (top to bottom): ");
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Search element in stack - returns position from top (1-based)
    int search(int key) {
        Node temp = top;
        int position = 1;
        while (temp != null) {
            if (temp.data == key) {
                return position;
            }
            temp = temp.next;
            position++;
        }
        return -1; // not found
    }

    // Clear stack
    void clear() {
        top = null;
        size = 0;
        System.out.println("Stack cleared");
    }

    // Reverse stack using recursion
    void reverse() {
        if (isEmpty() || top.next == null) {
            return;
        }
        Node temp = top;
        top = top.next;
        reverse();
        insertAtBottom(temp);
    }

    // Helper for reverse
    private void insertAtBottom(Node node) {
        if (isEmpty()) {
            top = node;
            node.next = null;
            return;
        }
        Node temp = top;
        top = top.next;
        insertAtBottom(node);
        node.next = top;
        top = temp;
        temp.next = node;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        stack st = new stack();

        while (true) {
            System.out.println("\n--- STACK MENU (Using Singly Linked List) ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek (View Top)");
            System.out.println("4. Check if Empty");
            System.out.println("5. Get Size");
            System.out.println("6. Display Stack");
            System.out.println("7. Search Element");
            System.out.println("8. Clear Stack");
            System.out.println("9. Reverse Stack");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int val = sc.nextInt();
                    st.push(val);
                    break;

                case 2:
                    st.pop();
                    break;

                case 3:
                    int topVal = st.peek();
                    if (topVal != -1) {
                        System.out.println("Top element: " + topVal);
                    }
                    break;

                case 4:
                    if (st.isEmpty()) {
                        System.out.println("Stack is empty");
                    } else {
                        System.out.println("Stack is not empty");
                    }
                    break;

                case 5:
                    System.out.println("Stack size: " + st.getSize());
                    break;

                case 6:
                    st.display();
                    break;

                case 7:
                    System.out.print("Enter element to search: ");
                    int key = sc.nextInt();
                    int pos = st.search(key);
                    if (pos != -1) {
                        System.out.println("Element " + key + " found at position " + pos + " from top");
                    } else {
                        System.out.println("Element not found");
                    }
                    break;

                case 8:
                    st.clear();
                    break;

                case 9:
                    st.reverse();
                    System.out.println("Stack reversed");
                    st.display();
                    break;

                case 10:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
