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
        // dfs(root, p, q);
        // return node;
        if (root==null){
            return null;
        }

        Map<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, null);
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode top = queue.remove();

            if(top.left!=null){
                map.put(top.left, top);
                queue.add(top.left);
            }

            if(top.right!=null){
                map.put(top.right, top);
                queue.add(top.right);
            }
        }

        Set<TreeNode> pancesestors = new HashSet<>();
        while(map.containsKey(p)){
            pancesestors.add(p);
            p = map.get(p);
        }

        while(!pancesestors.contains(q)){
            q = map.get(q);
        }
        return q;
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