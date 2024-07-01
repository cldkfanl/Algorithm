#include <string>
#include <vector>
#include<iostream>
using namespace std;

vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer(2,0);
    int xlen = park.size();
    int ylen = park[0].length();
    for(int i=0; i<park.size(); i++){
        for(int j=0; j<park[i].length(); j++){
            if(park[i][j] == 'S'){
                answer[0] = i;
                answer[1] = j;
            }
        }
    }
    for(int j=0; j<routes.size(); j++){
        char fir = routes[j][0];
        int sec = routes[j][2] - '0';
        bool check = true;
        
        switch(fir){
            case 'N' :
                if(answer[0] - sec >= 0){
                    for(int i=1; i<=sec; i++){
                        if(park[answer[0] - i][answer[1]] == 'X'){
                            check = false;
                            break;
                        }
                    }
                }
                else{
                    check = false;
                }
                if(check){
                    answer[0] -= sec;
                }
                break;
            case 'S' :
                if(answer[0] + sec < xlen){
                    for(int i=1; i<=sec; i++){
                        if(park[answer[0] + i][answer[1]] == 'X'){
                            check = false;
                            break;
                        }
                    }
                }
                else{
                    check = false;
                }
                if(check){
                    answer[0] += sec;
                }
                break;
            case 'W' :
                if(answer[1] - sec >= 0){
                    for(int i=1; i<=sec; i++){
                        if(park[answer[0]][answer[1] - i] == 'X'){
                            check = false;
                            break;
                        }
                    }
                }
                else{
                    check = false;
                }
                if(check){
                    answer[1] -= sec;
                }
                break;
            case 'E' :
                if(answer[1] + sec < ylen){
                    for(int i=1; i<=sec; i++){
                        if(park[answer[0]][answer[1] + i] == 'X'){
                            check = false;
                            break;
                        }
                    }
                }
                else{
                    check = false;
                }
                if(check){
                    answer[1] += sec;
                }
                break;
        }
    }
    return answer;
}