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
    vector<int> dp(N + 1);
    vector<int> trace(N + 1);
    dp[1] = 0;
    trace[1] = -1;
    for (int i = 2; i <= N; i++) {
        dp[i] = dp[i - 1] + 1;
        trace[i] = i - 1;
        if (i % 2 == 0 && dp[i] > dp[i/2] + 1) {
            dp[i] = min(dp[i], dp[i / 2] + 1);
            trace[i] = i / 2;
        }
        if (i % 3 == 0 && dp[i] > dp[i/3]+1) {
            dp[i] = min(dp[i], dp[i / 3] + 1);
            trace[i] = i / 3;
        }
    }
    cout << dp[N] << endl;

    for (int i = N; i > 0; i = trace[i]) {
        cout << i << " ";
    }
}