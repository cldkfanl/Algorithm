#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> lines) {
    
    std::vector<int> n_check(200);
    for(int i=0; i< lines.size(); i++){
        for(int j = lines[i][0]; j < lines[i][1]; j++){
            n_check[j+100]++;
        }
    }
    
    int answer = 0;
    for(int i = 0; i < n_check.size(); i++){
        answer = (n_check[i] > 1)? answer + 1 : answer;
    }
    return answer;
}