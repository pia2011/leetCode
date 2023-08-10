import java.util.*;

class Solution {
    public int findDuplicate(int[] nums) {
        
        int ans = 0;
        
        int lt = 0; 
        int rt = nums.length - 1; 
        
        while (lt <= rt) {
            int mid = lt + (rt - lt) / 2;
            int cnt = 0; 

            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }

            if (cnt > mid) {
                ans = mid;
                rt = mid - 1; 
            } else {
                lt = mid + 1; 
            }
        }

        return ans; 
    }
}