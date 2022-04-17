class Solution {
    public double average(int[] salary) {
        // 최대와 최소를 제외한 평균
        
        double ans = 0;
        Arrays.sort(salary);
        
        double sum = 0;
        for(int i = 1; i<salary.length - 1; i++){
            sum += salary[i];
        }
        
        ans = sum/(salary.length - 2);
        
        return ans;
    }
}