#include <string>
#include <vector>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    int fir = 0, sec = 0;
    while(s.length() > 1){
        int tmp = 0;
        for(int i=0; i<s.length(); i++){
            if(s[i] == '0'){
                tmp++;
            }
        }
        int tmp2 = s.length() - tmp;
        string s2 = "";
        while (tmp2 > 0) {
            s2 = (tmp2 % 2 == 0 ? "0" : "1") + s2;
            tmp2 /= 2;
        }
        sec += tmp;
        fir++;
        s = s2;
    }
    answer.push_back(fir);
    answer.push_back(sec);
    return answer;
}