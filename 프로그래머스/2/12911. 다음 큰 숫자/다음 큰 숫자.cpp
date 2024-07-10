#include <string>
#include <vector>

using namespace std;

int bitcnt(int num){
    int cnt = 0;
    while(num != 0){
        if(num % 2 == 1){
            cnt++;
        }
        num /= 2;
    }
    return cnt;
}


int solution(int n) {
    int answer = 0;
    int ncnt = bitcnt(n);
    while(true){
        n++;
        int cmp = bitcnt(n);
        if(ncnt == cmp){
            answer = n;
            break;
        }
    }
    return answer;
}