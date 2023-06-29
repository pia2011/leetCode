import java.util.*;
import java.io.*;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraCnt) {
        /**
        - classes[통과할 학생 수][총 학생 수] & extraCnt : 여분의 학생 수
        - toDo : 여분의 학생 수를 배분하여 최대 가능한 평균 통과 비율 반환
        
        HOW?

        여분의 학생들을 배정한 이후, 최대 가능한 평균 통과 비율을 반환하려면 각 반들이 최대한 많은 통과 비율을 가져야한다.
        학생을 배정하는 매 순간마다 최선의 선택을 해줘야 한다.
        
         */
        

        // 평균 통과 비율을 기준으로 반을 정렬
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> {
            double ratioA = (double)(a[0] + 1) / (a[1] + 1) - (double) a[0] / a[1];
            double ratioB = (double)(b[0] + 1) / (b[1] + 1) - (double) b[0] / b[1];
            return Double.compare(ratioB, ratioA);
        });

        for(int[] c : classes){
            pq.add(new double[]{c[0], c[1]});
        }

        while(extraCnt > 0){
            double[] top = pq.poll();
            top[0] += 1; // 통과한 한생 수 증가
            top[1] += 1; // 전체 학생 수 증가
            pq.add(top);
            extraCnt--; 
        }

        double totalRatio = 0.0;
        while(!pq.isEmpty()){
            double[] c = pq.poll();
            totalRatio += (double) c[0] / c[1];

        }
        return totalRatio / classes.length;
    }

} 