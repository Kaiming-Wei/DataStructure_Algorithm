import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversal {
    // Tree
    static class TreeNode<T>{
        public T value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(T value, TreeNode left, TreeNode right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    // Pre-Order, In-Order, Post-Order
    // Recursive
    // Time O(N), space O(N)
    public static void Recursive(TreeNode root){
        if(root == null){
            return;
        }
        // 1 time into the root;
        // and go to left child
        // Pre-Order
        //System.out.print(root.value + " ");

        Recursive(root.left);
        // 2 time back to the root, after finish it's left sub-tree
        // In-Order
        //System.out.print(root.value + " ");

        Recursive(root.right);
        // 3 time back to the root, after finish it's right sub-tree
        // Post-Order
        System.out.print(root.value + " ");
    }



    // Pre-Order (Head, Left, Right)
    // Iterative, using 1 stack
    // Time O(N), space O(N)
    public static void Pre_Order(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()){
            // pop, print
            root = stack.pop();
            System.out.print(root.value + " ");

            // right child first, it's a stack
            if(root.right != null){
                stack.push(root.right);
            }

            // left child
            if(root.left != null){
                stack.push(root.left);
            }
        }
    }




    // In-Order (Left, Head, Right)
    // Iterative, using 1 stack
    // Time O(N), space O(N)
    public static void In_Order(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(!stack.isEmpty() || root != null){
            // if not null, go to left child
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                // if no left child, go to right child, and follow the step 1
                root = stack.pop();
                System.out.print(root.value + " ");
                root = root.right;
            }
        }
    }




    // Post-Order (Left, Head, Right)
    // Iterative, using 2 stack
    // Time O(N), space O(N)
    public static void Post_Order(TreeNode root){
        if(root == null){
            return;
        }
        // same idea as pre-order
        // instead adding to the stack as (head, right, left)
        // and putting answers into another stack
        // it will reverse into (left, right, head), which is post order!!
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> reverse_stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()){
            // head first, and push to reverse stack
            root = stack.pop();
            reverse_stack.push(root);

            // right child
            if(root.left != null){
                stack.push(root.left);
            }

            // right child
            if(root.right != null){
                stack.push(root.right);
            }
        }

        // after that, pop and print every element in reverse stack
        while(!reverse_stack.isEmpty()){
            root = reverse_stack.pop();
            System.out.print(root.value + " ");
        }
    }




    // Post-Order (Left, Head, Right)
    // Iterative, using only 1 stack, 2 pointers
    // Time O(N), space O(N)
    public static void Post_Order2(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode pre = null, cur = null;

        while(!stack.isEmpty()){
            cur = stack.peek();
            if(cur.left != null && cur.left != pre && cur.right != pre){
                stack.push(cur.left);
            }else if(cur.right != null && cur.left == pre){
                stack.push(cur.right);
            }else{
                cur = stack.pop();
                System.out.print(cur.value + " ");
                pre = cur;
            }
        }
    }




    // Level-Order
    // Using a Queue
    // Time O(N), space O(N)
    public static void Level_Order(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()){
            root = queue.poll();
            System.out.print(root.value + " ");
            if(root.left != null){
                queue.add(root.left);
            }
            if(root.right != null){
                queue.add(root.right);
            }
        }
        System.out.println();
    }





    // test
    public static void main(String[] args) {
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node4 = new TreeNode(4, null, node6);
        TreeNode node5 = new TreeNode(5, node7, null);
        TreeNode node2 = new TreeNode(2, null, node4);
        TreeNode node3 = new TreeNode(3, node5, null);
        TreeNode node1 = new TreeNode(1, node2, node3);

        System.out.println("Recursive Pre-Order:");
        Recursive(node1);
        System.out.println();
        System.out.println("Iterative Pre-Order:");
        Pre_Order(node1);
        System.out.println();
        System.out.println("----------------------");


        System.out.println("Recursive In-Order:");
        Recursive(node1);
        System.out.println();
        System.out.println("Iterative In-Order:");
        In_Order(node1);
        System.out.println();
        System.out.println("----------------------");


        System.out.println("Recursive Post-Order:");
        Recursive(node1);
        System.out.println();
        System.out.println("Iterative Post-Order:");
        Post_Order(node1);
        System.out.println();
        System.out.println("Iterative Post-Order2:");
        Post_Order2(node1);
        System.out.println();
        System.out.println("----------------------");


        System.out.println("Level-Order:");
        Level_Order(node1);
    }
}
