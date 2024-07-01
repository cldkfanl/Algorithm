#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// cards1_len은 배열 cards1의 길이입니다.
// cards2_len은 배열 cards2의 길이입니다.
// goal_len은 배열 goal의 길이입니다.
// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* cards1[], size_t cards1_len, const char* cards2[], size_t cards2_len, const char* goal[], size_t goal_len) {
    int card1_state = 0;
    int card2_state = 0;
    int goal_state = 0;
    bool state = true;
    while(true){
        if(goal_state >= goal_len){
            break;
        }
        if(card1_state < cards1_len && strcmp(goal[goal_state], cards1[card1_state]) == 0){
            goal_state++;
            card1_state++;
        }
        else if(card2_state < cards2_len && strcmp(goal[goal_state], cards2[card2_state]) == 0){
            goal_state++;
            card2_state++;
        }
        else{
            state = false;
            break;
        }
    }
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    char* answer = (char*)malloc(4);
    if (state) {
        strcpy(answer, "Yes");
    } else {
        strcpy(answer, "No");
    }

    return answer;
    return answer;
}