class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        // 가능한 홀수길이(연속된) 배열의 합 : 1 3 5 7 9 ...
        int sum = 0;
        for(int i = 1; i<=arr.length; i+=2){ // 간격
            for(int j = 0; j<arr.length - i + 1; j++){ // 시작점
                for(int k = j; k<j + i; k++){
                    sum+= arr[k];
                }
            }
        }
        
        return sum;
    }
}