#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int main()
{
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    
    vector<bool> arr;
    for (auto i = 0; i <= 30; i++) {
        arr.push_back(0);
    }

    for (auto i = 0; i < 28; i++) {
        int num;
        cin >> num;
        arr[num] = true;
    }


    for (auto i = 1; i <= 30; i++) {
        if (!arr[i]) {
            cout << i << endl;
        }
    }

    return 0;
}