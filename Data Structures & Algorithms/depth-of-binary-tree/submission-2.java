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
    public int maxDepth(TreeNode root) {
        // if (root==null){
        //     return 0;
        // }

        // int left = maxDepth(root.left);
        // int right = maxDepth(root.right);

        // return 1+Math.max(left, right);
        if (root==null){
            return 0;
        }
        Stack<NodeHeightPair> stack = new Stack<>();
        stack.push(new NodeHeightPair(root, 1));
        int res =0;

        while(!stack.isEmpty()){
            NodeHeightPair top = stack.pop();
            System.out.println(top.node.val);
            res = Math.max(res, top.height);
            if(top.node.left!=null){
                stack.push(new NodeHeightPair(top.node.left, top.height+1));
            }
            if(top.node.right!=null){
                stack.push(new NodeHeightPair(top.node.right, top.height+1));
            }
        }
        return res;
        
    }
}

public class NodeHeightPair {
    TreeNode node;
    int height;

    NodeHeightPair(TreeNode node, int height){
        this.node = node;
        this.height = height;
    }

}
