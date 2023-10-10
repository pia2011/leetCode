import java.util.*;
class Solution {
    public boolean canJump(int[] nums) {
        // 마지막 인덱스에 도달할 수 있는가
        // 연료 문제
        
        int n = nums.length;
        int remain = nums[0];
        if(remain ==0 && n == 1) return true;
        if(remain == 0) return false;
        for(int i = 1; i<n; i++){
            remain--;
            if(remain < nums[i]) remain = nums[i];
            if(remain <= 0 && i != n - 1) return false;
        }
        
        return true;
    }
}