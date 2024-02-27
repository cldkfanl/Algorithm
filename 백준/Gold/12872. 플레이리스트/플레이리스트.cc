#include <bits/stdc++.h>
#include<iostream>
#include<regex>
using namespace std;




int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N, M, P;
    cin >> N >> M >> P;

    long long dp[101][101] = {};

    dp[0][0] = 1;
    for (int i = 1; i <= P; i++) {
        for (int j = 1; j <= N; j++) {
            dp[i][j] += dp[i-1][j - 1] * (N - j + 1);
            dp[i][j] %= 1000000007;
            if (j > M) {
                dp[i][j] += dp[i - 1][j] * (j - M);
                dp[i][j] %= 1000000007;
            }
        }
    }
    cout << dp[P][N];



    return 0;
}
 