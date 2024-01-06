class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            answer[i] = "";
        }
        //입력값 두개를 전부 이진수로 변환
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr1[i] % 2 == 1 || arr2[i] % 2 == 1) {
                    answer[i] = "#" + answer[i];
                } //둘중 하나라도 1이면 색칠
                else{
                    answer[i] = " " + answer[i];
                }
                arr1[i] /= 2;
                arr2[i] /= 2;
            }
        }

        return answer;
    }
}