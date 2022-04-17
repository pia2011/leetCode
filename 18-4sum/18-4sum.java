class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 숫자 4개의 합이 target이 되는 경우를 list에 담아 return / 순서는 상관없음 / unique : 중복 제외
        Set<List<Integer>> hs = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length - 3; i++){
            for(int j = i + 1; j<nums.length - 2; j++){
                System.out.println(i+" "+j);
                // 투포인터
                int left = j + 1;
                int right = nums.length - 1;
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right]; 
                    if(sum == target){
                        hs.add(Arrays.asList(nums[i],nums[j],nums[left++],nums[right--]));
                    }else if(sum < target){
                        left++;
                    }else if(sum > target){
                        right--;
                    }
                    
                }
                
            } 
        }
        
        return new ArrayList<>(hs);
    }
}