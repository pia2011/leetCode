## 풀이

이중 for문으로 모든 케이스를 구하면 O(N^2)의 시간복잡도를 가지고, n은 최대 10^5개 이므로, 100억개의 경우의 수를 가지를 가지고  TL이 난다.

### 예시

```java
        int left = 0;
        int right = height.length - 1;
        for(int i = 0; i<height.length - 1; i++){
            for(int j = i + 1; j<hgith.length; j++){
                ans = Math.max((right - left) * Math.min(height[left] , height[right]));
            }
        }
```

이 문제는 투 포인터를 활용해서 고려할 필요 없는 케이스들을 제외하면, 시간을 줄일 수 있다.

![image](https://user-images.githubusercontent.com/53935439/163666258-3744ee94-3d5a-4c1f-b906-99f49ccc1bf4.png)

위의 그림과 같은 케이스에서 아래와 같은 케이스들에서 사각형의 넓이를 구하면 무조건 넓이가 줄어들 수 밖에 없다. 왜냐하면 높이는 그대로이거나 줄어들 수 밖에 없는데, 폭은 줄어들기만 하기 때문이다. 따라서 아래와 같은 케이스들은 제외해 주어야한다.

![image](https://user-images.githubusercontent.com/53935439/163666311-52fe3b1a-d9a7-4237-a105-8b16bd155976.png)

위와 같은 케이스들을 제외해주려면 투포인터를 이용해서 양쪽 바의 높이 중에 높이가 더 작은 부분을 포인터를 오른쪽으로 옮겨주어야 한다. 그래야만 사각형의 넓이가 더 커질 수 있는 케이스들을 발견할 수 있다. 예를 들어 아래와 같은 케이스(사각형의 넓이가 더 커지는)를 발견할 수 있는 것이다.

![image](https://user-images.githubusercontent.com/53935439/163666567-53185999-83d3-4ba5-b58d-ea4627e51fd4.png)
