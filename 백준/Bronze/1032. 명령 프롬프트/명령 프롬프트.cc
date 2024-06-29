#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N;
    cin >> N;
    string input[51] = {};
    for (int i = 1; i <= N; i++) {
        cin >> input[i];
    }

    for (int i = 0; i < input[1].length(); i++) {
        bool status = true;
        char cmp = input[1][i];
        for (int j = 2; j <= N; j++) {
            if (cmp != input[j][i]) {
                status = false;
                break;
            }
        }
        if (status) {
            cout << cmp;
        }
        else {
            cout << "?";
        }
    }


    return 0;
}
 