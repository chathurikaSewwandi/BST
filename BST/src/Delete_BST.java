class Node {
        int key;
        Node left, right;

        Node(int item) {
            key = item;
            left = right = null;
        }
    }

    class Delete_BST  {
        Node root;

        Delete_BST () {
            root = null;
        }

        // insert a new node with the given key
        Node insert(Node node, int key) {
            // If the tree is empty, return a new node
            if (node == null) {
                return new Node(key);
            }

            // Otherwise, recur down the tree
            if (key < node.key) {
                node.left = insert(node.left, key);
            } else if (key > node.key) {
                node.right = insert(node.right, key);
            }

            // return the (unchanged) node pointer
            return node;
        }

        // A utility function to do inorder traversal of BST
        void inorder(Node root) {
            if (root != null) {
                inorder(root.left);
                System.out.print(root.key + " ");
                inorder(root.right);
            }
        }

        // Given a binary search tree and a key, this function deletes the key and returns the new root
        Node deleteNode(Node root, int key) {
            // Base case
            if (root == null) {
                return root;
            }

            // If the key to be deleted is smaller than the root's key, then it lies in the left subtree
            if (key < root.key) {
                root.left = deleteNode(root.left, key);
            }
            // If the key to be deleted is greater than the root's key, then it lies in the right subtree
            else if (key > root.key) {
                root.right = deleteNode(root.right, key);
            }
            // If key is same as root's key, then this is the node to be deleted
            else {
                // Node with only one child or no child
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }

                // Node with two children: Get the inorder successor (smallest in the right subtree)
                root.key = minValue(root.right);

                // Delete the inorder successor
                root.right = deleteNode(root.right, root.key);
            }

            return root;
        }

        int minValue(Node root) {
            int minv = root.key;
            while (root.left != null) {
                minv = root.left.key;
                root = root.left;
            }
            return minv;
        }

        // Driver Code
        public static void main(String[] args) {
            Delete_BST  tree = new Delete_BST ();


            tree.root = tree.insert(tree.root, 15);
            tree.insert(tree.root, 10);
            tree.insert(tree.root, 8);
            tree.insert(tree.root, 12);
            tree.insert(tree.root, 20);
            tree.insert(tree.root, 17);
            tree.insert(tree.root, 25);

            System.out.print("Original BST: ");
            tree.inorder(tree.root);
            System.out.println();

            System.out.println("\nDelete a Leaf Node: 8");
            tree.root = tree.deleteNode(tree.root, 8);
            System.out.print("Modified BST tree after deleting Leaf Node:\n");
            tree.inorder(tree.root);
            System.out.println();

            System.out.println("\nDelete Node with single child: 20");
            tree.root = tree.deleteNode(tree.root, 20);
            System.out.print("Modified BST tree after deleting single child Node:\n");
            tree.inorder(tree.root);
            System.out.println();

            System.out.println("\nDelete Node with both child: 15");
            tree.root = tree.deleteNode(tree.root, 15);
            System.out.print("Modified BST tree after deleting both child Node:\n");
            tree.inorder(tree.root);
        }
    }

