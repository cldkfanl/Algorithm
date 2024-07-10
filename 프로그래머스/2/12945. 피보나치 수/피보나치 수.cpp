#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    vector<int> arr(100001,0);
    arr[1] = 1;
    for(int i=2; i<=100000; i++){
        arr[i] = arr[i-1] + arr[i-2];
        arr[i] %= 1234567;
    }
    int answer = arr[n];
    return answer;
}