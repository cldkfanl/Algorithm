#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 1;
    for(int i=1; i<n; i++){
        int sum = i;
        int tmp = i+1;
        while(true){
            sum += tmp;
            tmp++;
            if(sum >= n){
                if(sum == n){
                    answer++;
                }
                break;
            }
            
        }
    }
    return answer;
}