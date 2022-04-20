class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 병합 정렬 : 결과는 nums1에 저장
        
        List<Integer> list = new LinkedList<>();
        
        for(int i = 0; i<m; i++){
            list.add(nums1[i]);
        }
        for(int i = 0; i<n; i++){
            list.add(nums2[i]);
        }
        
        Collections.sort(list);
        for(int i = 0; i<list.size(); i++){
            nums1[i] = list.get(i);
        }
        
        
        
    }
}