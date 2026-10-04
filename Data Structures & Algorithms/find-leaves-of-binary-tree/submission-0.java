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
    List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        height(root);
        return output;
    }

    public int height(TreeNode root){
        if(root ==null){
            return -1;
        }

        int leftHeight= height(root.left);
        int rightHeight = height(root.right);

        int height = Math.max(leftHeight, rightHeight)+1;
        if(output.size()==height){
            output.add(new ArrayList<>());
        }
        output.get(height).add(root.val);

        return height;
    }
}
