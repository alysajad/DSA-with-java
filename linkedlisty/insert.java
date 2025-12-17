import java.util.*;

class insert{
    Node head;
     class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            next=null;

        }
    }
        void push(int data1){
            Node newNode= new Node(data1);
            newNode.next=head;
            head=newNode;   
        }

        // Insert at end
        void insertAtEnd(int data1){
            Node newNode = new Node(data1);
            if(head == null){
                head = newNode;
                return;
            }
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }

        // Insert at middle (after position)
        void insertAtMiddle(int data1, int position){
            Node newNode = new Node(data1);
            if(head == null || position == 0){
                newNode.next = head;
                head = newNode;
                return;
            }
            Node temp = head;
            for(int i = 0; i < position - 1 && temp.next != null; i++){
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }

        // Delete at head
        void deleteAtHead(){
            if(head == null){
                System.out.println("List is empty");
                return;
            }
            System.out.println("Deleted head: " + head.data);
            head = head.next;
        }

        // Delete at middle (at position)
        void deleteAtMiddle(int position){
            if(head == null){
                System.out.println("List is empty");
                return;
            }
            if(position == 0){
                System.out.println("Deleted: " + head.data);
                head = head.next;
                return;
            }
            Node temp = head;
            for(int i = 0; i < position - 1 && temp.next != null; i++){
                temp = temp.next;
            }
            if(temp.next == null){
                System.out.println("Position out of bounds");
                return;
            }
            System.out.println("Deleted: " + temp.next.data);
            temp.next = temp.next.next;
        }

        // Delete at end
        void deleteAtEnd(){
            if(head == null){
                System.out.println("List is empty");
                return;
            }
            if(head.next == null){
                System.out.println("Deleted: " + head.data);
                head = null;
                return;
            }
            Node temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            System.out.println("Deleted: " + temp.next.data);
            temp.next = null;
        }

        void delete(){
            if(head==null){
                return;
            }
            Node node=head;

            while(node!=null && node.next!= null){
                node.next=node.next.next;
                node=node.next;

                
            }
        }

        void printlist(){
            Node temp=head;
            while(temp!=null){
                System.out.println(temp.data +" ");

                temp=temp.next;

            }
            System.out.println();

        }

        // Search by key - returns position of key (-1 if not found)
        int searchByKey(int key){
            Node temp = head;
            int position = 0;
            while(temp != null){
                if(temp.data == key){
                    return position;
                }
                temp = temp.next;
                position++;
            }
            return -1; // not found
        }

        // Search by position - returns data at position (-1 if invalid)
        int searchByPosition(int position){
            if(head == null){
                System.out.println("List is empty");
                return -1;
            }
            Node temp = head;
            int count = 0;
            while(temp != null){
                if(count == position){
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
        insert ll = new insert();
        
        while(true){
            System.out.println("\n--- LINKED LIST MENU ---");
            System.out.println("1. Insert at Head");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Middle (position)");
            System.out.println("4. Delete at Head");
            System.out.println("5. Delete at End");
            System.out.println("6. Delete at Middle (position)");
            System.out.println("7. Delete Alternate Nodes");
            System.out.println("8. Display List");
            System.out.println("9. Search by Key");
            System.out.println("10. Search by Position");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            
            switch(choice){
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
                    ll.delete();
                    break;
                    
                case 8:
                    System.out.println("Current List:");
                    ll.printlist();
                    break;
                    
                case 9:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }




   
 }
 
 


