#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    string input;
    cin >> input;
    int len = 0;
    vector<string> word = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
    
    for (int i = 0; i < word.size(); i++) {
        while (true) {
            len = input.find(word[i]);
            if (len == string::npos) {
                break;
            }
            input.replace(len, word[i].length(), "#");
        }
    }
    cout << input.length() << endl;
    return 0;
}