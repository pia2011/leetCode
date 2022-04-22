class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new LinkedList<>();
        
        int arr[][] = new int[numRows][numRows];
        arr[0][0] = 1;
        ans.add(new LinkedList<>(Arrays.asList(1)));
        for(int i = 1; i<numRows; i++){
            List<Integer> temp = new LinkedList<>();
            for(int j = 0; j<=i; j++){
                if(j == 0 || j == i) {
                    arr[i][j] = 1;
                    temp.add(arr[i][j]);
                }else if(0 < j && j < i){
                    arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
                    temp.add(arr[i][j]);
                }
            }
            ans.add(temp);
        }
        
        return ans;
    }
}