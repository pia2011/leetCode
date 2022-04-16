## 풀이

배열이 주어지고 배열속의 3개의 수를 합해서 0이 나온 케이스들을 List에 담아 리턴해주면 된다.

모든 경우의 수를 고려하면 배열의 길이가 최대 3000개 이므로, 삼중 포문으로 구성했을 때, 약 3000^3의 복잡도를 가지므로 100억이 넘어가므로 TL이 발생한다.
따라서 시간복잡도를 줄여야 풀 수 있는데, 여기에서 투포인터를 응용한다.

![image](https://user-images.githubusercontent.com/53935439/163673375-6d2e04d3-d1d1-412b-bad1-5ec8d82a9a35.png)

위와 같이 i는 for문으로 구성하여 그 안에서 투 포인터를 활용해서 찾으면 된다. 하나 고려해야 하는 것은 문제에서 중복된 케이스들은 제거하라고 했으니, Set을 활용해서 중복된 List는 담기지 못하게 한다.

이 문제는 다른 사람의 코드를 참고 했는데, 먼저 HashSet에 List를 담아주고, 반환할때 파라미터에 객체를 던져서 처리해준다. ArrayList.class에 다양한 인자들을 받을 수 있게끔 생성자가 많이 존재하는 듯 하다.


지금까지 설명했던 내용들을 코드로 나타내면 아래와 같다.

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        HashSet<List<Integer>> ans = new HashSet<>(); // 중복 경우 제외 
        
        for(int i = 0; i<nums.length - 2; i++){
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) ans.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                else if(sum < 0) left++;
                else if(sum > 0) right--;
            }
        }

        return new ArrayList<>(ans);
    }
}
```
