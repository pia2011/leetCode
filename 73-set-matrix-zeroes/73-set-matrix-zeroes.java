class Solution {
    static int n,m;
    public void setZeroes(int[][] matrix) {
        // 0기준 +
        n = matrix.length;
        m = matrix[0].length;
        
        
        boolean isCol = false;
        
        // step 1
        for(int i = 0; i<n; i++){
            
            if(matrix[i][0] == 0) isCol = true;
                
            for(int j = 1; j<m; j++){
                if(matrix[i][j] == 0){ 
                    matrix[i][0] = 0;
                    matrix[0][j] = 0; 
                }    
            }
        }
        
        // step 2
        for(int i = 1; i<n; i++){
            for(int j= 1; j<m; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        
        // step 3
        if(matrix[0][0] == 0){
            for(int i = 0; i<m; i++){
                matrix[0][i] = 0; 
            }
        }
        
        
        // step 4
        if(isCol){
            for(int i = 0; i<n; i++){
                matrix[i][0] = 0;
            }
        }
    }
}