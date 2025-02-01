#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int main()
{
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int N;
    cin >> N;
    vector<pair<int, int>> arr;
    for (auto i = 0; i < N; i++) {
        int fir, sec;
        cin >> fir >> sec;
        arr.push_back({ fir, sec });
    }
    sort(arr.begin(), arr.end());

    for (auto p : arr) {
        cout << p.first << " " << p.second << "\n";
    }
    return 0;
}