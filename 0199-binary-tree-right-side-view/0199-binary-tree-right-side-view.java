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
    private static List<Integer> ansList;
    public List<Integer> rightSideView(TreeNode root) {
        ansList = new ArrayList<>();
        // 기저 사례
        if(root == null) return ansList;
        
        dfs(root, 0);
        return ansList;
    }
    
    private void dfs(TreeNode node,int depth){
        // 기저 사례
        if(node == null) return;
        
        if(depth == ansList.size())
        ansList.add(node.val);
        
        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
    }
}