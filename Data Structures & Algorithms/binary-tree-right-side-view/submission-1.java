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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            TreeNode top = null;
            for(int i=0; i<size; i++){
                top = queue.remove();
                 if(top.left!=null){
                    queue.add(top.left);
                 }
                 if(top.right!=null){
                    queue.add(top.right);
                 }
            }
            // right most node;
            list.add(top.val);
        }

        System.out.println(list);

        return list;
    }
}
