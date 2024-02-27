#include <bits/stdc++.h>
#include<iostream>
#include<regex>
using namespace std;




int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int M;
    cin >> M;
    vector<pair<int,int>> arr;
    for (int i = 0; i < M; i++) {
        int fir, sec;
        cin >> fir >> sec;
        arr.push_back({ fir,sec });
    }

    sort(arr.begin(), arr.end());
    int dp[100] = {};

    for (int i = 0; i < M; i++) {
        int val = 0;
        for (int j = 0; j < i; j++) {
            if (arr[i].second > arr[j].second) {
                val = max(val, dp[j]);
            }
        }
        dp[i] = val + 1;
    }
    int maxlen = 0;
    for (int i = 0; i < 100; i++) {
        maxlen = max(maxlen, dp[i]);
    }


    cout << M - maxlen << endl;



    return 0;
}
 