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

    vector<int> dp(N + 1, INT_MAX);
    dp[N] = 0;

    for (int i = N; i > 0; i--) {
        if (i - 1 >= 0) {
            dp[i - 1] = min(dp[i - 1], dp[i] + 1);
        }
        if (i % 2 == 0 && i / 2 >= 0) {
            dp[i / 2] = min(dp[i / 2], dp[i] + 1);
        }
        if (i % 3 == 0 && i / 3 >= 0) {
            dp[i / 3] = min(dp[i / 3], dp[i] + 1);
        }
    }

    cout << dp[1] << endl;
    return 0;
}