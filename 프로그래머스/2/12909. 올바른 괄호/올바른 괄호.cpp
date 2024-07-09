#include <algorithm>
#include <iostream>

using namespace std;

bool solution(string s)
{
    bool answer = true;
    int state = 0;
    for(int i=0; i<s.length(); i++){
        if(s[i] == '('){
            state++;
        }
        else{
            state--;
        }
        if(state < 0){
            break;
        }
    }
    if(state != 0){
        answer = false;
    }
    return answer;
}