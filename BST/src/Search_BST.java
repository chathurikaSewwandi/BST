class Node1 {
        int key;
        Node left, right;

        public Node1(int item) {
            key = item;
            left = right = null;
        }
    }

    public class Search_BST {
        Node root;

        // Constructor
        Search_BST() {
            root = null;
        }

        // A utility function to insert

        Node insert(Node node, int key) {
            // If the tree is empty, return a new node
            if (node == null) {
                node = new Node(key);
                return node;
            }

            // Otherwise, recur down the tree
            if (key < node.key)
                node.left = insert(node.left, key);
            else if (key > node.key)
                node.right = insert(node.right, key);

            // Return the (unchanged) node pointer
            return node;
        }

        // Utility function to search a key in a BST
        Node search(Node root, int key) {
            // Base Cases: root is null or key is present at root
            if (root == null || root.key == key)
                return root;

            // Key is greater than root's key
            if (root.key < key)
                return search(root.right, key);

            // Key is smaller than root's key
            return search(root.left, key);
        }

        // Driver Code
        public static void main(String[] args) {
            Search_BST tree = new Search_BST();

            // Inserting nodes
            tree.root = tree.insert(tree.root, 15);
            tree.insert(tree.root, 10);
            tree.insert(tree.root, 8);
            tree.insert(tree.root, 12);
            tree.insert(tree.root, 20);
            tree.insert(tree.root, 17);
            tree.insert(tree.root, 25);

            // Key to be found
            int key = 1;

            // Searching in a BST
            if (tree.search(tree.root, key) == null) {
                System.out.println(key + " not found");
            } else
                System.out.println(key + " found");

            key = 12;

            // Searching in a BST
            if (tree.search(tree.root, key) == null)
                System.out.println(key + " not found");
            else
                System.out.println(key + " found");
        }
    }



