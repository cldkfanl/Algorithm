#include <string>
#include <vector>
#include <cmath>
#include <iostream> // <- 이게 있어야 cout 사용 가능

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    
    int yel_sqrt = std::sqrt(yellow);
    
    for(int i=1; i<= yel_sqrt; i++){
        if(yellow % i == 0){
            int row = i, col = yellow / i;
            if(brown == (row + col) * 2 + 4){
                answer.push_back(col + 2);
                answer.push_back(row + 2);
                break;
            }
        }
    }
    return answer;
}