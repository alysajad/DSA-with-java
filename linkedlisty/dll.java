import java.util.*;

class dll {
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

    // Insert at head
    void push(int data1) {
        Node newNode = new Node(data1);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
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

    // Insert at middle (after position)
    void insertAtMiddle(int data1, int position) {
        Node newNode = new Node(data1);
        if (head == null || position == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
            return;
        }
        Node temp = head;
        for (int i = 0; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        if (temp.next != null) {
            temp.next.prev = newNode;
        } else {
            tail = newNode;
        }
        temp.next = newNode;
    }

    // Delete at head
    void deleteAtHead() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Deleted head: " + head.data);
        if (head == tail) {
            head = tail = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }

    // Delete at middle (at position)
    void deleteAtMiddle(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (position == 0) {
            deleteAtHead();
            return;
        }
        Node temp = head;
        for (int i = 0; i < position && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }
        System.out.println("Deleted: " + temp.data);
        if (temp == tail) {
            tail = temp.prev;
            tail.next = null;
            return;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    // Delete at end
    void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Deleted: " + tail.data);
        if (head == tail) {
            head = tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }

    // Delete alternate nodes
    void deleteAlternate() {
        if (head == null) {
            return;
        }
        Node node = head;
        while (node != null && node.next != null) {
            Node toDelete = node.next;
            node.next = toDelete.next;
            if (toDelete.next != null) {
                toDelete.next.prev = node;
            } else {
                tail = node;
            }
            node = node.next;
        }
    }

    // Print list forward
    void printListForward() {
        Node temp = head;
        System.out.print("Forward: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Print list backward
    void printListBackward() {
        Node temp = tail;
        System.out.print("Backward: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    // Search by key - returns position of key (-1 if not found)
    int searchByKey(int key) {
        Node temp = head;
        int position = 0;
        while (temp != null) {
            if (temp.data == key) {
                return position;
            }
            temp = temp.next;
            position++;
        }
        return -1;
    }

    // Search by position - returns data at position (-1 if invalid)
    int searchByPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return -1;
        }
        Node temp = head;
        int count = 0;
        while (temp != null) {
            if (count == position) {
                return temp.data;
            }
            temp = temp.next;
            count++;
        }
        System.out.println("Position out of bounds");
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dll ll = new dll();

        while (true) {
            System.out.println("\n--- DOUBLY LINKED LIST MENU ---");
            System.out.println("1. Insert at Head");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Middle (position)");
            System.out.println("4. Delete at Head");
            System.out.println("5. Delete at End");
            System.out.println("6. Delete at Middle (position)");
            System.out.println("7. Delete Alternate Nodes");
            System.out.println("8. Display List (Forward)");
            System.out.println("9. Display List (Backward)");
            System.out.println("10. Search by Key");
            System.out.println("11. Search by Position");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert at head: ");
                    int val1 = sc.nextInt();
                    ll.push(val1);
                    System.out.println("Inserted " + val1 + " at head");
                    break;

                case 2:
                    System.out.print("Enter value to insert at end: ");
                    int val2 = sc.nextInt();
                    ll.insertAtEnd(val2);
                    System.out.println("Inserted " + val2 + " at end");
                    break;

                case 3:
                    System.out.print("Enter value to insert: ");
                    int val3 = sc.nextInt();
                    System.out.print("Enter position (0-based): ");
                    int pos1 = sc.nextInt();
                    ll.insertAtMiddle(val3, pos1);
                    System.out.println("Inserted " + val3 + " at position " + pos1);
                    break;

                case 4:
                    ll.deleteAtHead();
                    break;

                case 5:
                    ll.deleteAtEnd();
                    break;

                case 6:
                    System.out.print("Enter position to delete (0-based): ");
                    int pos2 = sc.nextInt();
                    ll.deleteAtMiddle(pos2);
                    break;

                case 7:
                    System.out.println("Deleting alternate nodes...");
                    ll.deleteAlternate();
                    break;

                case 8:
                    System.out.println("Current List:");
                    ll.printListForward();
                    break;

                case 9:
                    System.out.println("Current List:");
                    ll.printListBackward();
                    break;

                case 10:
                    System.out.print("Enter key to search: ");
                    int key = sc.nextInt();
                    int pos = ll.searchByKey(key);
                    if (pos != -1) {
                        System.out.println("Key " + key + " found at position: " + pos);
                    } else {
                        System.out.println("Key not found");
                    }
                    break;

                case 11:
                    System.out.print("Enter position to search (0-based): ");
                    int searchPos = sc.nextInt();
                    int data = ll.searchByPosition(searchPos);
                    if (data != -1) {
                        System.out.println("Data at position " + searchPos + ": " + data);
                    }
                    break;

                case 12:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
