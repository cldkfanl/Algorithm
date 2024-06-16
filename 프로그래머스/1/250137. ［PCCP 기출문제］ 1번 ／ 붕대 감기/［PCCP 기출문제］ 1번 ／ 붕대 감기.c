#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
// bandage_len은 배열 bandage의 길이입니다.
// attacks_rows는 2차원 배열 attacks의 행 길이, attacks_cols는 2차원 배열 attacks의 열 길이입니다.
int cal_hp(int bandage[], int start, int end){
    int time = end - start -1;
    
    int recovery = time * bandage[1];
    recovery += (time / bandage[0]) * bandage[2];
    return recovery;
}

int solution(int bandage[], size_t bandage_len, int health, int** attacks, size_t attacks_rows, size_t attacks_cols) {
    
    int answer = health;
    for(int i=0; i< attacks_rows; i++){
        answer -= attacks[i][1];
        if(answer <= 0){
            return -1;
        }
        if(i < attacks_rows -1){
            int calhp = cal_hp(bandage, attacks[i][0], attacks[i+1][0]);
            answer += calhp;
        }
        if(answer > health){
            answer = health;
        }
    }
    return answer;
}