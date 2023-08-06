/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return null;
        }
        HashMap<String, List<TreeNode>> map = new HashMap<String, List<TreeNode>>();
        Tree(1, n, map);
        return map.get("1--" + n);
    }

    // from start# to end#, find all binary tree
    // map is used to voild repeat calculation
    private List<TreeNode> Tree(int start, int end, HashMap<String, List<TreeNode>> map){
        // check map
        String key = start + "--" + end;
        if(map.containsKey(key)){
            return map.get(key);
        }

        // base case
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if(start > end){
            ans.add(null);
            return ans;
        }


        // for every int, it can be the root value
        for(int root_val = start; root_val <= end; root_val++){
            // calculate all it's left subtree
            List<TreeNode> leftchild = Tree(start, root_val - 1, map);
            List<TreeNode> rightchild = Tree(root_val + 1, end, map);

            // for every left child, it must match up to every right child
            for(TreeNode left : leftchild){
                for(TreeNode right : rightchild){
                    TreeNode root = new TreeNode(root_val);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }

        // update map and return
        map.put(key, ans);
        return ans;
    }
}
