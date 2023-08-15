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
    
    // 재귀, 중위 순회 : 왼쪽 먼저
    private Stack<Integer> stack = new Stack<>();
    public int kthSmallest(TreeNode root, int k) {       
        
        dfs(root, k);
        
        return stack.pop();
    }
    
    private void dfs(TreeNode node, int k){
        if(node == null || stack.size() >= k) return; // 기저 사례
        dfs(node.left, k);
        if(stack.size() >= k) return;
        stack.push(node.val);
        if(stack.size() >= k) return;
        dfs(node.right, k);
        if(stack.size() >= k) return;
    }
}