import java.util.*;

public class dll1 {
    Node head;
    Node tail;

    class Node{
        int data;
        Node next;
        Node prev;

        Node (int data){
            this.data=data;
            next=prev=null;


        }
    }

    void insert(int data1){
        Node newnode=new Node(data1);

        if(head==null){
            head=tail=newnode;
            return;
        }
        newnode.next=head;
        head.prev=newnode;
        head=newnode;

    }

    void insertatend(int data1){
        Node newnode=new Node(data1);
        if(head==null){
            head = tail=newnode;
            return;
        }

        tail.next=newnode;
        newnode.prev=tail;
        tail=newnode;
    }

    void insertmiddle(int data2, int position){
        Node newnode=new Node(data2);
        if(head==null || position==0){
            newnode.next=head;

        if(head!=null){
            head.prev=newnode;
        }
        return;
        }

        Node temp= head;

        for(int i=0;i<position- 1 &&  temp.next!=null;i++){
            temp=temp.next;

        }
        newnode.prev=temp.next;
        newnode.prev=temp;

        if(temp.next!=null){
            temp.next.prev=newnode;

        }
        else{
            tail=newnode;

        }
        temp.next=newnode;
        }
        
    }



    }

    
}
