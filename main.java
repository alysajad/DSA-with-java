
import java.util.Scanner;
class Node{
    int data;
    Node next;

    Node(int data1,Node next1){
        data=data1;
        next=next1;
    }

    Node (int data1){
        data=data1;
        next=null;
    }
}

class Solution{
    public Node insertathead(Node head,int newdata){
        Node newnode=new Node(newdata,head);
        return newnode;

    }
    public void printlist(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.data +" ");
            temp=temp.next;
        }
        System.err.println();
    }
}
public class main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Solution sol=new Solution();

        Node head=null;

        System.out.print("enter the no.of nodes");
        int n = sc.nextInt();


        for(int i=0;i<n;i++){
            System.out.print("enter values : ");
            int value =sc.nextInt();
            head=sol.insertathead(head, value);

        }
    System.out.println("\n final LL");
    sol.printlist(head);

    }
}

