#include <string>
#include <vector>

using namespace std;

string solution(string X, string Y) {
    string answer = "";
    int arr1[10] = {};
    int arr2[10] = {};
    for(int i=0; i<X.length(); i++){
        int tmp = X[i] - '0';
        arr1[tmp]++;
    }
    for(int i=0; i<Y.length(); i++){
        int tmp = Y[i] - '0';
        arr2[tmp]++;
    }
    for(int i=9; i>=0; i--){
        int tmp = min(arr1[i], arr2[i]);
        if(i == 0 && tmp > 0 && answer.empty()){
            answer += to_string(0);
        }
        else{
            for(int j=0; j<tmp; j++){
                answer +=  to_string(i);
            }  
        }
    }
    if(answer.empty()){
        answer = "-1";
    }
    return answer;
}