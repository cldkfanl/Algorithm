#include <string>
#include <vector>

using namespace std;

int gcd(int a, int b){
    while(b != 0){
        int r = a % b;
        a = b;
        b = r;
    }
    return a;
}

int lcm(int a, int b){
    return a * b / gcd(a, b);
}


int solution(vector<int> arr) {
    
    int answer = arr[0];
    
    if(arr.size() == 1){
        return answer;
    }
    
    for(auto i =1; i< arr.size(); i++){
        answer = lcm(answer, arr[i]);
    }
    return answer;
}