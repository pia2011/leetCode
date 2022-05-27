class Solution {
    public boolean isPowerOfThree(int n) {
        // 3의 제곱수이면
        
        return Integer.toString(n ,3).matches("^10*$");
    }
}