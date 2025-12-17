import java.util.*;


class Node{
    int data;
    Node lchild,rchild;

    public Node(int item){
        data=item;
        lchild=rchild=null;
    }
    public void DisplayNode(){
        System.out.println(data);
    }


}

class BST{
    Node root;
    
    Node insert(Node root, int key ){
        if(root==null){
            return new Node(key);
        }

        if(key<root.data) root.lchild=insert(root.lchild,key);
        else if(key>root.data) root.rchild = insert(root.lchild ,key);

        return root;

    }

    Node findmin(Node root){
        while(root.lchild!=null){
            root=root.lchild;

        }
    return root;

    }

    Node Delete(Node root, int key){
        if(root==null)return null;

        if(key<root.data){
            root.lchild=Delete(root.lchild,key);

        }
        else if(key>root.data){
            root.lchild=Delete(root.lchild,key);

        }

        else{
            //case no child;

            if(root.lchild==null && root.rchild==null){
                return null;
            }
            else if(root.lchild==null)
                return root.lchild;
            else if(root.rchild==null)
                return root.rchild;

            Node temp=findmin(root.rchild);
            root.data=temp.data;
            root.rchild=Delete(root.rchild,temp.data);

        }
        return root;
    }

    //traversals

    void inorder(Node root){
        if(root!=null){
            inorder(root.lchild);
            System.out.println(root.data +" ");
            inorder(root.rchild);
        }
    }

    void preorder(Node root){
        if(root!=null){
            System.out.println(root.data +" ");
            preorder(root.lchild);
            preorder(root.rchild);

        }

    }
    void postorder(Node root){
        if(root!=null){
            postorder(root.lchild);
            postorder(root.lchild);
            System.out.println(root.data +" ");

        }
    }
}

public class treemenu{
    public static void main(String[] args) {
        
        Scanner sc= new Scanner (System.in);
        BST tree=new BST();

        while (true){
            System.out.println("\n--- TREE OPERATIONS MENU ---");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Inorder Traversal");
            System.out.println("4. Preorder Traversal");
            System.out.println("5. Postorder Traversal");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int val = sc.nextInt();
                    tree.root = tree.insert(tree.root, val);
                    break;

                case 2:
                    System.out.print("Enter value to delete: ");
                    int del = sc.nextInt();
                    tree.root = tree.Delete(tree.root, del);
                    break;

                case 3:
                    System.out.println("Inorder Traversal:");
                    tree.inorder(tree.root);
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Preorder Traversal:");
                    tree.preorder(tree.root);
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Postorder Traversal:");
                    tree.postorder(tree.root);
                    System.out.println();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            


        }

    }
    }
}