import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree_Min_Max_Deep {
    // Giving a binary tree
    // Find it's minimum deep to one of it's leaf node

    // Tree structure
    static class TreeNode<T>{
        public T value;
        public TreeNode left;
        public TreeNode right;
        public int level;

        public TreeNode(T value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
        public TreeNode(T value, TreeNode left, TreeNode right){
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public boolean isLeaf(){
            if(this.left == null && this.right ==null){
                return true;
            }
            return false;
        }
    }

    // MinDeep
    // by DFS and recursive solution
    public static int minDeep_DFS(TreeNode root){
        if(root == null){
            return 0;
        }
        return process(root);
    }
    private static int process(TreeNode root){
        if(root.left == null && root.right == null){
            return 1;
        }

        int min = Integer.MAX_VALUE;
        if(root.left != null){
            min = Math.min(min, process(root.left) + 1);
        }
        if(root.right != null){
            min = Math.min(min, process(root.right) + 1);
        }
        return min;
    }

    // by BFS and using Queue
    public static int minDeep_BFS(TreeNode root){
        if(root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        // we need to known what level is each node, so we need add one variable to TreeNode
        root.level = 1;

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.isLeaf()){
                return node.level;
            }
            if(node.left != null){
                q.offer(node.left);
                node.left.level = node.level + 1;
            }
            if(node.right != null){
                q.offer(node.right);
                node.right.level = node.level + 1;
            }
        }
        return 0;
    }


    // MaxDeep  DFS   Recursive
    public static int maxDeep_DFS(TreeNode root){
        if(root == null){
            return 0;
        }
        return max_process(root);
    }
    private static int max_process(TreeNode root){
        if(root.isLeaf()){
            return 1;
        }
        int max = Integer.MIN_VALUE;
        if(root.left != null){
            max = Math.max(process(root.left) + 1, max);
        }
        if(root.right != null){
            max = Math.max(process(root.right) + 1, max);
        }
        return max;
    }

    // MaxDeep  BFS   Queue
    public static int maxDeep_BFS(TreeNode root){
        if(root == null){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        root.level = 1;

        while (!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.isLeaf()){
                max = Math.max(max, node.level);
            }
            if(node.left != null){
                q.offer(node.left);
                node.left.level = node.level + 1;
            }
            if(node.right != null){
                q.offer(node.right);
                node.right.level = node.level + 1;
            }
        }
        return max;
    }

    //test
    public static void main(String[] args) {
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node5 = new TreeNode<Integer>(5);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2,node4,node5);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6,null,node7);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3,null,node6);
        TreeNode<Integer> node1 = new TreeNode<Integer>(1,node2,node3);

        // minDeep  DFS  recursive
        System.out.println(minDeep_DFS(node1));

        // minDeep  BFS
        System.out.println(minDeep_BFS(node1));


        // maxDeep   DFS  recursive
        System.out.println(maxDeep_DFS(node1));

        // maxDeep  BFS Queue
        System.out.println(maxDeep_BFS(node1));
    }
}
