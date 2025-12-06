import java.util.Scanner;

class Node {
    int coef, exp;
    Node next;

    Node(int c, int e) {
        coef = c;
        exp = e;
        next = null;
    }
}

class Polynomial {

    // Insert term & combine like terms
    public Node insertTerm(Node head, int c, int e) {

        // zero coefficient → ignore
        if (c == 0) return head;

        Node newNode = new Node(c, e);

        // case 1: list empty
        if (head == null) return newNode;

        Node curr = head, prev = null;

        // check if exponent already exists → combine like terms
        while (curr != null) {
            if (curr.exp == e) {
                curr.coef += c;
                return head;
            }
            prev = curr;
            curr = curr.next;
        }

        // if exponent not found → insert at end
        prev.next = newNode;

        return head;
    }

    // Multiply two polynomials
    public Node multiply(Node p1, Node p2) {
        Node result = null;

        for (Node t1 = p1; t1 != null; t1 = t1.next) {
            for (Node t2 = p2; t2 != null; t2 = t2.next) {
                
                int newCoef = t1.coef * t2.coef;
                int newExp  = t1.exp + t2.exp;

                result = insertTerm(result, newCoef, newExp);
            }
        }
        return result;
    }

    // Display polynomial
    public void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.coef + "x^" + temp.exp);
            if (temp.next != null) System.out.print(" + ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Create polynomial using user input
    public Node createPolynomial() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        Node head = null, tail = null;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter coefficient: ");
            int c = sc.nextInt();
            System.out.print("Enter exponent: ");
            int e = sc.nextInt();

            Node newNode = new Node(c, e);

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }
}

public class PolyMultiply {
    public static void main(String[] args) {

        Polynomial p = new Polynomial();

        System.out.println("Enter Polynomial 1:");
        Node poly1 = p.createPolynomial();

        System.out.println("Enter Polynomial 2:");
        Node poly2 = p.createPolynomial();

        System.out.println("\nPolynomial 1:");
        p.display(poly1);

        System.out.println("Polynomial 2:");
        p.display(poly2);

        Node result = p.multiply(poly1, poly2);

        System.out.println("\nResultant Polynomial (Multiplication):");
        p.display(result);
    }
}
