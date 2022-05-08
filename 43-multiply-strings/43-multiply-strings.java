class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length(); 
        int m = num2.length();
        int result[] = new int[n + m];
        
        // 0이 발생하는 경우
        if(num1.equals("0") || num2.equals("0")) return "0";
        
        for(int i = n - 1; i>=0; i--){
            for(int j = m - 1; j>=0; j--){
                
                int temp = result[i + j + 1]; // 원래 자리 값
                temp += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                
                result[i + j + 1] = temp % 10;
                result[i + j] += temp / 10; // 올림 수
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int x : result){
            if(sb.length() == 0 && x == 0) continue; // ex> 2 * 3
            sb.append(x);
        }
        
        return sb.toString();
    }
}