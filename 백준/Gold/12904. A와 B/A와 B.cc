#include <bits/stdc++.h>
#include<iostream>
using namespace std;

// 그리디
// S -> T 가 아닌 T -> S로 만들기
// T의 끝 글자에 따라서 두가지 행동으로 분류
int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);


    string S, T;

    cin >> S >> T;

    while (1) {
        if (T[T.size() - 1] == 'A') {
            T.pop_back();
        }
        else {
            T.pop_back();
            reverse(T.begin(), T.end());
        }

        if (S.size() == T.size()) {
            if (S == T) {
                cout << 1 << endl;
            }
            else {
                cout << 0 << endl;
            }
            break;
        }
    }
    
    return 0;
}
 