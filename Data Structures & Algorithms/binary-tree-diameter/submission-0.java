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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null){
            return 0;
        }
        Map<TreeNode, int[]> map = new HashMap<>();
        map.put(null, new int[]{0,0});

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode top = stack.peek();
            if(top.left!=null && !map.containsKey(top.left)){
                stack.push(top.left); 
            } else if (top.right!=null && !map.containsKey(top.right)){
                stack.push(top.right); 
            } else {
                top = stack.pop();
                int leftHeight = map.get(top.left)[0];
                int rightHeight = map.get(top.right)[0];

                int leftDiameter = map.get(top.left)[1];
                int rightDiameter = map.get(top.right)[1];

                int height = 1+Math.max(leftHeight, rightHeight);

                int diameter = Math.max(leftHeight+rightHeight, Math.max(leftDiameter, rightDiameter));

                map.put(top, new int[]{height, diameter});
            }
        }
        return map.get(root)[1];
    }
}
