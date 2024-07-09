#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string s) {
    vector<int> arr;
    string tmp = "";
    for(int i=0; i<=s.length(); i++){
        if(i<s.length() && s[i] != ' '){
            tmp += s[i];
        }
        else{
            if(!tmp.empty()){
                arr.push_back(stoi(tmp));
                tmp = "";
            }
        }
    }
    sort(arr.begin(), arr.end());
    string answer = to_string(arr[0]) + " " + to_string(arr[arr.size()-1]);
    return answer;
}