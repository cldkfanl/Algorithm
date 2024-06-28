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
    stack<int> sta;
    for (int i = 0; i < N; i++) {
        string input;
        cin >> input;
        int num;
        if (input == "push") {
            cin >> num;
            sta.push(num);
        }
        else if (input == "pop") {
            if (sta.empty()) {
                cout << -1 << endl;
            }
            else {
                cout << sta.top() << endl;
                sta.pop();
            }
        }
        else if (input == "size") {
            cout << sta.size() << endl;
        }
        else if (input == "empty") {
            if (sta.empty()) {
                cout << 1 << endl;
            }
            else {
                cout << 0 << endl;
            }
        }
        else {
            if (sta.empty()) {
                cout << -1 << endl;
            }
            else {
                cout << sta.top() << endl;
            }
        }
    }

    return 0;
}