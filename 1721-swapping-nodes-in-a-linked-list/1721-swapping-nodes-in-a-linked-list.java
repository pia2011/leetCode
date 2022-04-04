/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode node = head;
        List<ListNode> nodeList = new ArrayList<>();
        
        while(node != null){
            nodeList.add(node);
            node = node.next;
        }
        
        // swap
        int len = nodeList.size();
        int temp = nodeList.get(k - 1).val; 
        nodeList.get(k - 1).val = nodeList.get(len - k).val;
        nodeList.get(len - k).val = temp;
        
        return head;
    }
}