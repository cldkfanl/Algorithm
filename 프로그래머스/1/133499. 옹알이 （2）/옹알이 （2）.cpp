#include <string>
#include <vector>

using namespace std;

int solution(vector<string> babbling) {
    int answer = 0;
    
    string foo[4] = {"aya", "ye", "woo", "ma"};
    int check = -1;
    
    for(int i =0; i<babbling.size(); ++i){
        auto word = babbling[i];
        
        for(int j =0; j< 4; ++j){
            if(word.substr(0, foo[j].size()) == foo[j] && check != j){
                word.erase(0, foo[j].size());
                
                check = j;
                j = -1;
            }
        }
        if(word.size() == 0){
            ++answer;
        }
        check = -1;
    }
    
    return answer;
}