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
    public boolean isValidBST(TreeNode root) {
        // 1st approach in order travesel and then check if array is in sorted order. 
        // List<Integer> list = new ArrayList<>();
        // inOrder(root, list);
        // for(int i=1; i<list.size();i++){
        //     if(list.get(i)<=list.get(i-1)){
        //         return false;
        //     }
        // }

        // return true;

        // 2nd approach recruisve DFS
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public void inOrder(TreeNode root, List<Integer> list){
        if(root.left!=null){
            inOrder(root.left, list);
        }
        list.add(root.val);
        if(root.right!=null){
            inOrder(root.right, list);
        }
    }

    public boolean isValidBST(TreeNode root, int min, int max){
        if(root==null){
            return true;
        }
        if(root.val>=max || root.val<=min){
            return false;
        }

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
