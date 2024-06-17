public class Insert_BST {


    class Node {
        int key;
        Node left, right;

        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    Insert_BST() { root = null; }

    Insert_BST (int value) { root = new Node(value); }

    // This method mainly calls insertRec()
    void insert(int key) { root = insertRec(root, key); }


    // insert a new key in BST
    Node insertRec(Node root, int key)
    {
        // If the tree is empty,
        // return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        else if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        // Return the  node
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder() { inorderRec(root); }

    // do inorder traversal of BST
    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        Insert_BST tree = new Insert_BST();

        /* Let us create following BST
              15
           /     \
          10      20
         /  \    /  \
       8  12  17  25 */
        tree.insert(15);
        tree.insert(10);
        tree.insert(8);
        tree.insert(12);
        tree.insert(20);
        tree.insert(17);
        tree.insert(25);

        // Print inorder traversal of the BST
        tree.inorder();
    }
}