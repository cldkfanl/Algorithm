#include <bits/stdc++.h>
#include<iostream>
#include<regex>
using namespace std;
int hp[21] = {};
int happy[21] = {};
int dp[21][101] = {};


//dp
//배낭문제
int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;
    for (int i = 1; i <= N; i++) {
        cin >> hp[i];
    }
    for (int i = 1; i <= N; i++) {
        cin >> happy[i];
    }

    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= 100; j++) {
            if (hp[i] >= j) {
                dp[i][j] = dp[i-1][j];
            }
            else {
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - hp[i]] + happy[i]);
            }

        }
    }
    cout << dp[N][100] << endl;


    return 0;
}
 