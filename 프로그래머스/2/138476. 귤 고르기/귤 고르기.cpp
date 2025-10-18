#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int k, vector<int> tangerine) {
    unordered_map<int,int> cnt_map;
    for(int t : tangerine){
        cnt_map[t]++;
    }
    
    vector<int> tmp;
    for(auto &p: cnt_map){
        tmp.emplace_back(p.second);
    }
    sort(tmp.begin(), tmp.end(), greater<int>());
    
    int answer = 0;
    int count = 0;
    for(int i=0; i<tmp.size(); i++){
        count += tmp[i];
        answer++;
        if(count >= k){
            break; 
        }
    }
    return answer;
}