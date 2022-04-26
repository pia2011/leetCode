class Solution {
    public String intToRoman(int num) {
        // 예외 고려 : 4,9로 시작하는 수
        StringBuilder sb = new StringBuilder();
        int p[] = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String r[] = new String[]{"M", "CM", "D", "CD", "C", "XC","L","XL", "X", "IX", "V", "IV", "I"};
        
        // for(int i = 0; i<p.length; i++){
        //     if(i%2 == 0 && num/p[i] > 0){
        //         while(num/p[i] != 0){
        //             sb.append(r[i]);
        //             num -= p[i];
        //         }
        //     }else if(i%2 != 0 && num/p[i] == 1){ // 배수 적용 안됨 : only 1
        //         sb.append(r[i]);
        //         num -= p[i];
        //     }
        // }
        
        for(int i = 0; i<p.length; i++){
            while(num/p[i] > 0){
                sb.append(r[i]);
                num -= p[i];
            }
        }
        
        return sb.toString();
    }
}