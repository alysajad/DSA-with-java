class Node{
    int data ;
    Node next;

    Node(int data1){
        data=data1;
        next=null;

    }
}
class cycle{
    static boolean iscycle(Node head){
        Node slow= head, fast=head;
        while(slow!=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast= fast.next.next;

            if(slow==fast){
                return true;

            }
        }
        return false;


    }
    public static void main(String[] args) {
        
        Node head=new Node(1);
        head.next=new Node(9);
        head.next.next=new Node(6);
        head.next.next.next=new Node(5);

        if(iscycle(head)){
            System.out.println("loop");

        }
        else{
            System.err.println("notloop");

        }
    }
}
