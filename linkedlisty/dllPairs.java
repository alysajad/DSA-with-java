import java.util.*;

class dllPairs {
    Node head;
    Node tail;

    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    // Insert at end
    void insertAtEnd(int data1) {
        Node newNode = new Node(data1);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Print list forward
    void printList() {
        Node temp = head;
        System.out.print("Doubly Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Find pairs with given target sum
    void findPairs(int target) {
        if (head == null || head == tail) {
            System.out.println("Not enough elements to form pairs");
            return;
        }

        System.out.println("Pairs with sum = " + target + ":");
        boolean found = false;

        // Two pointer approach - one from start, one from end
        Node left = head;
        Node right = tail;

        while (left != right && left.prev != right) {
            int sum = left.data + right.data;

            if (sum == target) {
                System.out.println("(" + left.data + ", " + right.data + ")");
                found = true;
                left = left.next;
                right = right.prev;
            } else if (sum < target) {
                left = left.next;
            } else {
                right = right.prev;
            }
        }

        if (!found) {
            System.out.println("No pairs found with sum = " + target);
        }
    }

    // Find all pairs (brute force - works for unsorted list too)
    void findAllPairs(int target) {
        if (head == null || head == tail) {
            System.out.println("Not enough elements to form pairs");
            return;
        }

        System.out.println("All pairs with sum = " + target + ":");
        boolean found = false;

        Node outer = head;
        while (outer != null) {
            Node inner = outer.next;
            while (inner != null) {
                if (outer.data + inner.data == target) {
                    System.out.println("(" + outer.data + ", " + inner.data + ")");
                    found = true;
                }
                inner = inner.next;
            }
            outer = outer.next;
        }

        if (!found) {
            System.out.println("No pairs found with sum = " + target);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dllPairs dll = new dllPairs();

        // Get number of nodes
        System.out.print("Enter the number of nodes: ");
        int n = sc.nextInt();

        // Enter the values
        System.out.println("Enter " + n + " values:");
        for (int i = 0; i < n; i++) {
            System.out.print("Value " + (i + 1) + ": ");
            int val = sc.nextInt();
            dll.insertAtEnd(val);
        }

        // Print the list
        System.out.println();
        dll.printList();

        // Get target sum
        System.out.print("\nEnter target sum: ");
        int target = sc.nextInt();

        // Find and print pairs
        System.out.println();
        System.out.println("--- Using Brute Force (works for any list) ---");
        dll.findAllPairs(target);

        System.out.println("\n--- Using Two Pointer (for sorted list) ---");
        dll.findPairs(target);

        sc.close();
    }
}
