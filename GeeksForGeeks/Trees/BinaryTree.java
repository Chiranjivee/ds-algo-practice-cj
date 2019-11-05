import java.util.Queue;
import java.util.LinkedList;

class BinaryTree {
    TreeNode root;

    public void inorder() {
        if (root == null) {
            System.out.println("Root is null");
            return;
        }
        inOrderUtil(root);
        System.out.println();
    }

    public void inOrderUtil(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderUtil(node.left);
        System.out.print(node.data);
        inOrderUtil(node.right);
    }

    public void insert(int data) {
        if (root == null) {
            this.root = new TreeNode(data);
            return;
        }

        this.root = insertUtil(root, data);
    }

    public void delete(int data) {
        if (root == null) return;
        this.root = deleteUtil(root, data);
    }

    public TreeNode deleteUtil(TreeNode node, int data) {
        if (node.data == data && node.left == null && node.right == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        TreeNode dataNode = null;
        TreeNode deepestNode = null;
        while (!queue.isEmpty()) {
            deepestNode = queue.remove();
            if (deepestNode.data == data) {
                dataNode = deepestNode;
            }
            if (deepestNode.left != null) queue.offer(deepestNode.left);
            if (deepestNode.right != null) queue.offer(deepestNode.right);
        }

        dataNode.data = deepestNode.data;
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            if (temp.left != null) {
                if (temp.left == deepestNode) {
                    temp.left = null;
                    return node;
                }
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                if (temp.right == deepestNode) {
                    temp.right = null;
                    return node;
                }
                queue.offer(temp.right);
            }
        }

        return node;
    }

    public boolean contains(int data) {
        if (root == null) return false;
        return containsUtil(root, data);
    }

    public boolean containsUtil(TreeNode node, int data) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            if (temp.data == data) {
                return true;
            }
            if (temp.left != null) queue.offer(temp.left);
            if (temp.right != null) queue.offer(temp.right);
        }

        return false;
    }

    public TreeNode insertUtil(TreeNode root, int data) {
        TreeNode node = new TreeNode(data);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            if (temp.left == null) {
                temp.left = node;
                break;
            } else if (temp.right == null) {
                temp.right = node;
                break;
            }
        }
        return root;
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.inorder();

        tree.delete(2);
        tree.inorder();
        tree.delete(1);
        tree.inorder();
        tree.delete(3);
        tree.inorder();

        System.out.println("Contains 5:" + tree.contains(5));
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}