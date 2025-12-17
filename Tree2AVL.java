public class Tree2AVL {
    public class AVL {
        public class Node {
            private int value;
            private int height;
            private Node left;
            private Node right;

            public Node(int value) {
                this.value = value;
                this.height = 0;
            }

            public int getValue() {
                return value;
            }
        }

        private Node root;
        private int llCount;
        private int rrCount;
        private int lrCount;
        private int rlCount;

        public AVL() {
        }

        public int height(Node node) {
            return node == null ? -1 : node.height;
        }

        public boolean isEmpty() {
            return root == null;
        }

        public void populate(int[] nums) {
            for (int num : nums) {
                insert(num);
            }
        }

        public void populateSorted(int[] nums) {
            populateSorted(nums, 0, nums.length);
        }

        private void populateSorted(int[] nums, int start, int end) {
            if (start >= end) {
                return;
            }
            int mid = (start + end) / 2;
            insert(nums[mid]);
            populateSorted(nums, start, mid);
            populateSorted(nums, mid + 1, end);
        }

        public void insert(int value) {
            root = insert(value, root);
        }

        private Node insert(int value, Node node) {
            if (node == null) {
                return new Node(value);
            }

            if (value < node.value) {
                node.left = insert(value, node.left);
            } else if (value > node.value) {
                node.right = insert(value, node.right);
            } else {
                return node; // ignore duplicates
            }

            node.height = Math.max(height(node.left), height(node.right)) + 1;
            return rotate(node);
        }

        private Node rotate(Node node) {
            int balance = height(node.left) - height(node.right);

            if (balance > 1) {
                if (height(node.left.left) >= height(node.left.right)) {
                    llCount++;
                    System.out.println("Rotation: LL at " + node.value);
                    return rightRotate(node);
                } else {
                    lrCount++;
                    System.out.println("Rotation: LR at " + node.value);
                    node.left = leftRotate(node.left);
                    return rightRotate(node);
                }
            }

            if (balance < -1) {
                if (height(node.right.right) >= height(node.right.left)) {
                    rrCount++;
                    System.out.println("Rotation: RR at " + node.value);
                    return leftRotate(node);
                } else {
                    rlCount++;
                    System.out.println("Rotation: RL at " + node.value);
                    node.right = rightRotate(node.right);
                    return leftRotate(node);
                }
            }

            return node;
        }

        public Node rightRotate(Node p) {
            Node c = p.left;
            Node t = c.right;

            c.right = p;
            p.left = t;

            p.height = Math.max(height(p.left), height(p.right)) + 1;
            c.height = Math.max(height(c.left), height(c.right)) + 1;

            return c;
        }

        public Node leftRotate(Node p) {
            Node c = p.right;
            Node t = c.left;

            c.left = p;
            p.right = t;

            p.height = Math.max(height(p.left), height(p.right)) + 1;
            c.height = Math.max(height(c.left), height(c.right)) + 1;

            return c;
        }

        public boolean balanced() {
            return balanced(root);
        }

        private boolean balanced(Node node) {
            if (node == null) {
                return true;
            }
            int diff = Math.abs(height(node.left) - height(node.right));
            return diff <= 1 && balanced(node.left) && balanced(node.right);
        }

        public void display() {
            display(root, "ROOT NODE: ");
        }

        private void display(Node node, String details) {
            if (node == null) {
                return;
            }
            System.out.println(details + node.value);
            display(node.left, "LEFT CHILD OF " + node.value + ": ");
            display(node.right, "RIGHT CHILD OF " + node.value + ": ");
        }

        public void preOrder() {
            preOrder(root);
        }

        private void preOrder(Node node) {
            if (node == null) {
                return;
            }
            System.out.println(node.value + " ");
            preOrder(node.left);
            preOrder(node.right);
        }

        public void inOrder() {
            inOrder(root);
        }

        private void inOrder(Node node) {
            if (node == null) {
                return;
            }
            inOrder(node.left);
            System.out.println(node.value + " ");
            inOrder(node.right);
        }

        public void postOrder() {
            postOrder(root);
        }

        private void postOrder(Node node) {
            if (node == null) {
                return;
            }
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.value + " ");
        }

        public void printRotationSummary() {
            System.out.println("\nRotation summary: LL=" + llCount + ", LR=" + lrCount + ", RR=" + rrCount + ", RL=" + rlCount);
        }
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " values:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Tree2AVL outer = new Tree2AVL();
        AVL avl = outer.new AVL();

        avl.populate(nums);

        System.out.println("\nAVL balanced? " + avl.balanced());
        System.out.println("Pre-order traversal:");
        avl.preOrder();
        System.out.println("\nIn-order traversal:");
        avl.inOrder();
        System.out.println("\nPost-order traversal:");
        avl.postOrder();
        avl.printRotationSummary();
        sc.close();
    }
}

