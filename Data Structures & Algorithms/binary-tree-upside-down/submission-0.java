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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        
        if (root == null){
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        TreeNode head = stack.pop();
        TreeNode curNode = head;
        while(!stack.isEmpty()){
            System.out.println("Sagar");
            TreeNode top = stack.pop();
            curNode.left = top.right;
            curNode.right = top;
            top.left = null;
            top.right = null;
            curNode = top;
        }

        return head;
    }
}
