import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new LinkedList<>();
        
        boolean visited[] = new boolean[nums2.length];
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int prev = 0;
        for(int i = 0; i<nums1.length; i++){
            for(int j = prev; j<nums2.length; j++){ // 이전에 탐색했던 범위 제외
                if(!visited[j] && nums1[i] == nums2[j]){
                    list.add(nums1[i]);
                    visited[j] = true;
                    prev = j + 1;
                    break;
                }
                
            }
        }
        
        int[] ans = new int[list.size()];
        for(int i = 0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        
        
        return ans;
    }
}