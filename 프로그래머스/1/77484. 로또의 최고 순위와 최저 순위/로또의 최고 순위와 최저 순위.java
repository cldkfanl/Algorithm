class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zero = 0;
        for(int i=0; i<6; i++){         //지워진 숫자의 갯수를 카운트
            if(lottos[i] == 0){
                zero++;
            }
        }
        boolean flag[] = new boolean[6];
        int cnt = 0;
        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                if(!flag[i]){
                    if(lottos[i] == win_nums[j]){   //남은 숫자 중 맞은 갯수를 카운트
                    cnt++;
                        flag[i] = true;
                    }
                }
            }
        }
        System.out.println(zero + "/" + cnt);   //지워진 숫자가 다 맞을경우 = max, 다 틀릴경우 = min
        int max = 7 - zero - cnt;
        if(max >= 6){
            max = 6;
        }
        int min = 7 - cnt;
        if(min >= 6){
            min = 6;
        }
        int[] answer = {max , min};
        return answer;
    }
}