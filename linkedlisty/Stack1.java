import java.util.*;
import java.util.Scanner;

class Stack1{
    Node top;
    int size;
class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        next=null;
    }


}

Stack1(){
top=null;
size=0;
}
public void push(int data1){
    Node newnode= new Node(data1);

    newnode.next=top;
    top= newnode;
    size++;


}

int pop(){
    if(isempty()){
        System.out.println("stack empty ");
        return -1;

    }
    int popped=top.data;
    top=top.next;
    size--;

    System.out.println("popped"+ popped);
    return popped;


}

int peek(){
    if(isempty()){
        System.out.println("stack empty ");
        return -1;

    }
    return top.data;



}

boolean isempty(){
    return top==null;

}

int getSize(){
    return size;

}

void display(){
    if(isempty()){
        System.out.println(" stack empty ");
        return;
    }
    Node temp=top;
    while(temp!=null){
        System.out.println(temp.data);
        temp=temp.next;
    }
    System.out.println();
}

int search (int key){
    Node temp=top;
    int position=1;
    while(temp!=null){
        if(temp.data==key){
            return position;

        }
        temp=temp.next;
        position++;

    }
    return -1;


}

public static void main(String [] args){
    Scanner sc = new Scanner(System.in);

    Stack1 st=new Stack1();

    while(true){
        System.out.println("\n--- STACK MENU ---");
        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Search");
        System.out.println("4. Peek");
        System.out.println("5. Display");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");

        int choice=sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("enter the value to push");
                int val = sc.nextInt();
                st.push(val);
                break;
            case 2:
                System.out.println("popped  "+ st.pop());
                break;
            
            case 3:
                System.out.print("Enter the key to search: ");
                int key = sc.nextInt();
                int pos = st.search(key);
                if(pos != -1){
                    System.out.println("Element found at position " + pos + " from top");
                } else {
                    System.out.println("Element not found");
                }
                break;

            case 4:
                int topVal = st.peek();
                if(topVal != -1){
                    System.out.println("Top element: " + topVal);
                }
                break;

            case 5:
                st.display();
                break;

            case 6:
                System.out.println("Exiting...");
                sc.close();
                return;

            default:
                System.out.println("Invalid choice!");
                break;
        }



    }


}



}