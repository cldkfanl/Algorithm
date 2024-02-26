#include <bits/stdc++.h>
#include<iostream>
#include<regex>
using namespace std;

//regex include 해서 사용
//사용법 익히기

void regexPattern(string cmp) {
    if (regex_match(cmp, regex("(100+1+|01)+"))) {
        cout << "YES" << endl;
    }
    else {
        cout << "NO" << endl;
    }
}


int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int T;
    cin >> T;

    for (int i = 0; i < T; i++) {
        string cmp;
        cin >> cmp;

        regexPattern(cmp);
    }

    return 0;
}
 