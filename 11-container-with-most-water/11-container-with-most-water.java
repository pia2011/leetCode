class Solution {
    public int maxArea(int[] height) {
        
        // 모든 케이스를 따질 필요가 없다.
        
        int left = 0;
        int right = height.length - 1;
        int ans = (right - left)*Math.min(height[left], height[right]);
        System.out.println(ans);
        
        while(left < right){
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            } 
            ans = Math.max(ans, Math.min(height[left], height[right]) * (right - left));
        }
        
        return ans;
    }
}