#include <iostream>
#include<string>
#include<stack>
using namespace std;

stack<char> st;
int solution(string s)
{
    for(size_t i=0; i<s.length(); i++){
        if(st.empty()){
            st.push(s[i]);
        }
        else if(st.top() == s[i]){
            st.pop();
        }
        else{
            st.push(s[i]);
        }
    }

    return st.empty();
}