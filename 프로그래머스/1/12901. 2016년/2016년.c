#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

char* solution(int a, int b) {
    // 리턴할 값은 메모리를 동적 할당해주세요.
    int month[12] = {31,29,31,30,31,30,31,31,30,31,30,31};
    char* day[7] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    int state = 5;
    for(int i=0; i<a-1; i++){
        state += month[i];
    }
    state += b-1;
    state %= 7;
    char* answer = (char*)malloc(8);
    strcpy(answer, day[state]);
    return answer;
}