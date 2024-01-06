import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        double arr[][] = new double[N+1][2];
        int check[][] = new int[N+1][2];
        for(int i=0; i<stages.length; i++){
            for(int j=1; j<=N; j++){
                if(j == stages[i]){
                    check[j][1]++;
                }
                if(j <=stages[i]){
                    check[j][0]++;
                }
            }
        }
        for(int i=1; i<=N; i++){
            if (check[i][0] == 0) {
                arr[i][1] = 0; // 분모가 0인 경우 실패율을 0으로 설정
            } else {
                arr[i][1] = (double) check[i][1] / check[i][0];
            }
            arr[i][0] = i;
        }
        Arrays.sort(arr, 1, N + 1, new Comparator<double[]>() {
            @Override
            public int compare(double[] entry1, double[] entry2) {
                // 실패율을 내림차순으로 정렬
                if (entry1[1] == entry2[1]) {
                    return Double.compare(entry1[0], entry2[0]); // 실패율이 같을 경우 스테이지 번호를 오름차순으로 정렬
                }
                return Double.compare(entry2[1], entry1[1]);
            }
        });
        int answer[] = new int[N];
        for(int i=0; i<N; i++){
            answer[i] = (int)arr[i+1][0];
        }
        return answer;
    }
}