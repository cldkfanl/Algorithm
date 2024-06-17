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

    int dp[5001];
    dp[3] = dp[5] = 1;

    for (int i = 6; i <= 5000; i++) {
        if (dp[i - 3] > 0) {
            dp[i] = dp[i - 3] + 1;
        }
        if (dp[i - 5] > 0) {
            dp[i] = dp[i - 5] + 1;
        }
    }
    if (dp[N] == 0) {
        cout << -1 << endl;
    }
    else {
        cout << dp[N] << endl;
    }

    return 0;
}