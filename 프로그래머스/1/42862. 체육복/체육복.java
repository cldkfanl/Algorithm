class Solution {
    static int count = 0;
    static int arr[];
    public int solution(int n, int[] lost, int[] reserve) {
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = 1;
        }
        for(int i=0; i<lost.length; i++){
            arr[lost[i]-1] --;
        }
        for(int i=0; i<reserve.length; i++){
            arr[reserve[i]-1] ++;
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                if(i>0 && arr[i-1] == 2){
                    arr[i-1] --;
                    arr[i] ++;
                }
                else if(i<arr.length-1 && arr[i+1] == 2){
                    arr[i+1] --;
                    arr[i] ++;
                }
            }
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i] > 0){
                count++;
            }
        }
        return count;
    }
}