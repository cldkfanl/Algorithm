#include <string>
#include <vector>

using namespace std;

int solution(vector<string> babbling) {
    vector<string> avail = {"aya", "ye", "woo", "ma"};
    int answer = 0;
    
    for(const auto& s : babbling){
        int n_used_mask = 0;
        size_t i = 0;
        bool b_ok = true;
        
        while(i < s.size() && b_ok){
            int n_matched = -1;
            
            for(int t = 0; t< 4; ++ t){
                const string& w = avail[t];
                if(i + w.size() <= s.size() && s.compare(i, w.size(), w) == 0){
                    n_matched = t;
                    break;
                }
            }
            if(n_matched == -1){
                b_ok = false;
                break;
            }
            
            if(n_used_mask & (1 << n_matched)){
                b_ok = false;
                break;
            }
            
            n_used_mask |= (1 << n_matched);
            i += avail[n_matched].size();
        }
        
        if(b_ok && i == s.size()){
            ++ answer;
        }
    }
    return answer;
}