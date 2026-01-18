#include <string>
#include <vector>

using namespace std;

vector<int> solution(int numer1, int denom1, int numer2, int denom2) {
    int a = numer1 * denom2 + numer2 * denom1;
    int b = denom1 * denom2;
    
    int c = min(a,b);
    int cmp_num = 2;
    while(true){
        if(cmp_num > c){
            break;
        }
        if(a % cmp_num == 0 && b % cmp_num == 0){
            a /= cmp_num;
            b /= cmp_num;
        }
        else{
            cmp_num++;
        }
    }
    
    
    vector<int> answer;
    answer.push_back(a);
    answer.push_back(b);
    return answer;
}