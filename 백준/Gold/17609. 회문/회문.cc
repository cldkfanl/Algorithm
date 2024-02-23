#include <bits/stdc++.h>
#include<iostream>
using namespace std;


//펠린드롬 검사
//재귀

int palindrome(int fir , int sec, int status,  string cmp) {
    while (fir < sec) {
        if (cmp[fir] != cmp[sec]) { //오답 발견 시 최초 일 경우
            if (status == 0) {
                if (palindrome(fir + 1, sec, 1, cmp) == 0 || palindrome(fir, sec - 1, 1, cmp) == 0) { 
                    //한글자씩 넘겨서 다시 재귀 실행, 둘중 하나 성공시 1 리턴
                    return 1;
                }
                else {
                    return 2;
                }
            }
            else {
                return 2;
            }
        }
        else {
            fir++;
            sec--;
        }
    }
    return 0;
}


int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    vector<string> V;
    for (int i = 0; i < T; i++) {
        string input;
        cin >> input;
        int len = input.length();
        
        cout << palindrome(0, input.length() - 1, 0, input) << endl;
    }

    return 0;
}
 