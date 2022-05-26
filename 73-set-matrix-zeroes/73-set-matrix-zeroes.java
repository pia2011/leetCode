class Solution {
    public void setZeroes(int[][] matrix) {
        // 배열의 0이 위치한 곳에서 상하좌우를 모두 0으로 채워준다.
        int n = matrix.length;
        int m = matrix[0].length;
        boolean isCol = false;
        
        for(int i = 0; i<n; i++){
            if(matrix[i][0] == 0) isCol = true;
            for(int j = 1; j<m; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = 1; i<n; i++){
            for(int j = 1; j<m; j++){
               if(matrix[0][j] == 0 || matrix[i][0] == 0) matrix[i][j] = 0; 
            }
        }
        
        if(matrix[0][0] == 0){
            for(int i = 0; i<m; i++) matrix[0][i] = 0;
        }
        
        if(isCol){
            for(int i = 0; i<n; i++) matrix[i][0] = 0;
        }
        
    }
}