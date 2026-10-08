/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode node = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        node = null;
        dfs(root, p, q);
        return node;
    }

    public boolean[] dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || node!=null){
            return new boolean[]{false, false};
        }

        boolean[] left = dfs(root.left, p, q);
        boolean[] right = dfs(root.right, p, q);

        boolean pfound = left[0] || right[0] || root == p;
        boolean qfound = left[1] || right[1] || root == q;
        if(pfound && qfound && node==null){
            node = root;
        }

        return new boolean[]{pfound, qfound};
    }
}