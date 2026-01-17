#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(vector<vector<int>> dots) {
    for(int i =0; i< dots.size(); i ++){
        for(int j = i + 1; j < dots.size(); j++){
            int dx1 = dots[j][0] - dots[i][0];
            int dx2 = dots[j][1] - dots[i][1];
            
            for(int k =0; k<dots.size(); k++){
                for(int l =k + 1; l <dots.size() ; l++){
                    if(i == k || i == l || j == k || j == l){
                        continue;
                    }
                    int dx3 = dots[l][0] - dots[k][0];
                    int dx4 = dots[l][1] - dots[k][1];
                    
                    if(dx1 * dx4 == dx3 * dx2){
                        return 1;
                    }
                }
            }
        }
    }
    return 0;
}