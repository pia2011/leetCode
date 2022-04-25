class Solution {
    public int diagonalSum(int[][] mat) {
        // 대각선의 모든 합을 반환 : i == j || i == (m - 1 - j)
        int ans = 0;
        
        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[0].length; j++){
                 if(i == j || i == mat[0].length - 1 - j){
                     ans += mat[i][j];
                 }
            }
            
        }
        
        return ans;
        
    }
}