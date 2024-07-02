#include <string>
#include <vector>
#include<iostream>
#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    sort(lottos.begin(), lottos.end());
    sort(win_nums.begin(), win_nums.end());
    int zero = 0;
    int correct = 0;
    for(int i=0; i<6; i++){
        if(lottos[i] == 0){
            zero++;
        }
        else{
            for(int j=0; j<6; j++){
                if(lottos[i] == win_nums[j]){
                    correct++;
                }
            }
        }
    }
    vector<int> answer;
    if(7-(zero+correct)<6){
        answer.push_back(7-(zero+correct));
    }
    else{
        answer.push_back(6);
    }
    if(7-correct <6){
        answer.push_back(7-correct);
    }
    else{
        answer.push_back(6);
    }
    return answer;
}