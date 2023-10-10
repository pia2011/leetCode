import java.util.*;

class Solution {
    public int maxSubArray(int[] nums) {
        // 가장 큰 합을 가지는 부분합

        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for(int num : nums){
            sum += num;
            if(num > sum) sum = num;
            ans = Math.max(sum, ans);
        }

        return ans;
    }
}