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
    
    // k 번째 작은 값
    
    private List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        int ret = -1;
        dfs(root, k);
        
        Collections.sort(list);
        
        return list.get(k-1);
    }
    private void dfs(TreeNode node, int k){
        if(node == null) return;
        list.add(node.val);
        
        dfs(node.left, k);
        dfs(node.right, k);
    }
    
}