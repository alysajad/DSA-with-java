import java.util.*;
import java.util.Scanner;

class ll{
    Node head;
    Node tail;

    ll(){
        head=tail=null;

    }

    class Node{
        int data;
        Node next;


        Node(int data){
            this.data=data;
            next=null;


        }

    }

    public void push (int data){

        Node newNode= new Node(data);
        newNode.next=head;
        head=newNode;
    }

    void deletealt(){
        if (head==null) return;
        
        Node node=head;
        while(node!=null && node.next!=null){
            node.next=node.next.next;
            node=node.next;

        }
    }

    void printlist(){

        Node temp=head;

        while(temp!=null){
            System.out.println(" "+ temp.data);
            temp=temp.next;

        }
        System.out.println();
    }

    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        ll l= new ll();


        System.out.println("enter the number of node");
        int n = sc.nextInt();
        System.out.println("enter the nodes");
        for(int i =0;i<n;i++){
            int val=sc.nextInt();
            l.push(val);

        }
        System.out.println("linkedlist before deletion ");
        l.printlist();
        //System.out.println("=>" );
        System.out.println("ll after detetion");

        l.deletealt();
       // System.out.println("=>");
        l.printlist();
        sc.close();
    }
}