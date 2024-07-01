#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    vector<int> arr(n+1, 0);
    sort(lost.begin(), lost.end());
    sort(reserve.begin(), reserve.end());
    for(int i=0; i<lost.size(); i++){
        arr[lost[i]]--;
    }
    for(int i=0; i<reserve.size(); i++){
        arr[reserve[i]]++;
    }
    for(int i=0; i<reserve.size(); i++){
        if(arr[reserve[i]] == 1){
            if(arr[reserve[i] - 1] == -1){
                arr[reserve[i] - 1]++;
            }
            else if(arr[reserve[i] + 1] == -1){
                arr[reserve[i] + 1]++;
            }
        }
    }
    int answer = 0;
    for(int i=1; i<=n; i++){
        if(arr[i] != -1){
            answer ++;
        }
    }
    return answer;
}