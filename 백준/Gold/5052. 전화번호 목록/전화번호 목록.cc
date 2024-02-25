#include <bits/stdc++.h>
#include<iostream>
using namespace std;


//문자열
//트리



int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;
    for (int i = 0; i < T; i++) {
        int n;
        cin >> n;
        vector<string> input(n);
        set<string> callmap;
        for (int j = 0; j < n; j++) {
            cin >> input[j];
        }
        sort(input.begin(), input.end());

        bool state = true;
        for (int j = 0; j < n; j++) {
            string tmp = "";

            for (int k = 0; k < input[j].length(); k++) {
                tmp += input[j][k];
                if (callmap.find(tmp) != callmap.end()) {
                    state = false;
                    cout << "NO" << endl;
                    break;
                }
            }
            if (!state) {
                break;
            }
            callmap.insert(input[j]);
        }
        if (state) {
            cout << "YES" << endl;
        }
    }

    return 0;
}
 