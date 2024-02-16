#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int cnt = 0;
    string input, cmp = "UCPC";
    getline(cin, input);
    for (int i = 0; i < input.length(); i++) {
        if (input[i] == cmp[cnt]) {
            cnt++;
        }
    }

    if (cnt < 4) {
        cout << "I hate UCPC" << endl;
    }
    else {
        cout << "I love UCPC" << endl;
    }

    return 0;
}
 