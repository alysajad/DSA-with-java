import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data1, Node next1){
        data = data1;
        next = next1;
    }

    Node(int data1){
        data = data1;
        next = null;
    }
}

class Solution {
    // Search key and return index (0-based)
    public int search(Node head, int key){
        Node curr = head;
        int index = 0;

        while (curr != null){
            if (curr.data == key){
                return index;       // key found
            }
            curr = curr.next;
            index++;
        }
        return -1;  // key not found
    }
}

public class search {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        Node head = null, tail = null;

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        // USER INPUT INSERTION
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value: ");
            int val = sc.nextInt();
            Node newNode = new Node(val);

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // SEARCH KEY
        System.out.print("Enter key to search: ");
        int key = sc.nextInt();

        Solution sol = new Solution();
        int pos = sol.search(head, key);

        if (pos != -1) {
            System.out.println("Key found at index: " + pos);
        } else {
            System.out.println("Key not found");
        }

        sc.close();
    }
}
