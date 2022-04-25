class Solution {
    public int diagonalSum(int[][] mat) {
        // 대각선의 모든 합을 반환 : i == j || i == (m - 1 - j) - case 1
        
        int ans = 0;
        if(mat.length % 2 != 0) ans -= mat[mat.length/2][mat.length/2]; // remove overlap
        for(int i = 0; i<mat.length; i++){
            ans += mat[i][i] + mat[i][mat[0].length - 1 - i];
        }
        
        return ans;
        
    }
}