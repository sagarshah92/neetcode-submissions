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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        
        // if ((root.val>=p.val && root.val<=q.val) || (root.val>=q.val && root.val<=p.val)){
        //     System.out.println("called");
        //     return root;
        // } else if (root.val>p.val && root.val>q.val){
        //     lowestCommonAncestor(root.left, p,q);
        // } else {
        //     lowestCommonAncestor(root.right, p,q);
        // }
        while (root!=null){
            System.out.println("Root: "+root.val+" P: "+p.val+" Q: "+q.val);
                if ((root.val>=p.val && root.val<=q.val) || (root.val>=q.val && root.val<=p.val)){
                System.out.println("called");
                return root;
            } else if (root.val>p.val && root.val>q.val){
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;

    }
}
