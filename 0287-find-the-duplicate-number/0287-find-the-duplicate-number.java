import java.util.*;

class Solution {
    public int findDuplicate(int[] nums) {
        
//         int ans = 0;
        
//         Set<Integer> hs = new HashSet<>();
//         for(int num : nums){
//             if(!hs.contains(num)){
//                 hs.add(num);
//             }else {
//                 ans = num;
//             }
//         }        
        
//         return ans;
        
        int ans = -1;
        int prev = -1;
        Arrays.sort(nums);
        for(int num : nums){
            if(prev == num){ 
                ans = num;
                break;
            }
            prev = num;
        }
        
        return ans;
    }
}