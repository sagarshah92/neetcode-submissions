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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode top = null;

        while(!queue.isEmpty()){
            top = queue.remove();
            if(top.val==subRoot.val){
                boolean isEqual = isEqual(top, subRoot);
                if (isEqual){
                    return true;
                }
            }

            if(top.left!=null){
                queue.add(top.left);
            }
            if(top.right!=null){
                queue.add(top.right);
            }
        }

        return false;
    }

    public boolean isEqual(TreeNode t1, TreeNode t2){
        if(t1== null && t2==null){
            return true;
        }
        if(t1==null){
            return false;
        }
        if(t2==null){
            return false;
        }

        return t1.val==t2.val && isEqual(t1.left, t2.left) && isEqual(t1.right, t2.right);
    }
}
