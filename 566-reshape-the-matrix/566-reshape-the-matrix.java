class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        // 주어진 2차원 배열을 r행 c열로 변환해서 반환
        int n = mat.length;
        int m = mat[0].length;
        int [][]ans = new int[r][c];
        
        if(r * c != n * m) return mat;
        
        for(int i = 0; i<n; i++){
            for(int j= 0; j<m; j++){
                int idx = i*m + j;
                ans[idx/c][idx%c] = mat[i][j];
            }
        }
        
        return ans;
    }
}