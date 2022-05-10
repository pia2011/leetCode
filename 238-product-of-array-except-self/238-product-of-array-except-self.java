class Solution {
    public int[] productExceptSelf(int[] nums) {
        // O(N)안에 처리..?
        int a = 1;
        boolean zero1 = false;
        boolean zero2 = false;
        boolean isZero[] = new boolean[nums.length];
        for(int i = 0; i<nums.length; i++){
            
            if(nums[i] == 0){   
                isZero[i] = true;
                if(zero1) {
                    zero2 = true;
                    zero1 = false;
                    continue;
                }
                if(!zero2) zero1 = true;
            }
            
            a *= nums[i];
        }
        int temp = 1;
        if(zero1){
            for(int i = 0; i<nums.length; i++){
                if(!isZero[i])
                    temp *= nums[i];
            }
        }
    
        int ans[] = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            if(zero1){
                if(isZero[i]){
                    ans[i] = temp;
                }else{
                    ans[i] = 0;
                }
            }else if(zero2){
                ans[i] = 0;
            }else{
                ans[i] = a / nums[i];    
            }
            
        }
        
        return ans;
    }
}