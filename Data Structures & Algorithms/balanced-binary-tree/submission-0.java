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
    public boolean isBalanced(TreeNode root) {

        
        return dfs(root).isBalanced;
    }

    public Tupple dfs(TreeNode root){
        if(root==null){
            return new Tupple(0, true, null);
        }

        Tupple left = dfs(root.left);
        Tupple right = dfs(root.right);
        boolean isBalanced = left.isBalanced && right.isBalanced && (Math.abs(left.height-right.height)<=1);

        int height= 1+Math.max(left.height, right.height);

        return new Tupple(height, isBalanced,root );




    }
}

class Tupple {
    int height;
    boolean isBalanced;
    TreeNode node;

    public Tupple(int height, boolean isBalanced, TreeNode node){
        this.height = height;
        this.isBalanced = isBalanced;
        this.node = node;
    }
}


