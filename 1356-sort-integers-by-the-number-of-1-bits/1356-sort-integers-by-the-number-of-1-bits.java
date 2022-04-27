class Solution {
    public int[] sortByBits(int[] arr) {
        // 2진수로 바꿨을 때 갖는 비트의 수를 기준으로 오름차순 정렬하기

        LinkedList<Point> list = new LinkedList<>();
        for(int i = 0; i<arr.length; i++){
            // String s = Integer.toBinaryString(arr[i]);
            // int cnt = (int)s.chars().filter(c -> c == '1').count();
            int cnt = Integer.bitCount(arr[i]);
            list.add(new Point(arr[i], cnt));
        } 
        
        Collections.sort(list);
        
        int ans[] = new int[list.size()];
        for(int i = 0; i<list.size(); i++){
            ans[i] = list.get(i).num;
        }
        
        return ans;
    }
   
     static class Point implements Comparable<Point>{
        int num, cnt;
        
        Point(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(Point o){
            if(cnt == o.cnt){
                return num - o.num;
            }else return cnt - o.cnt;
        }
        
    }
}