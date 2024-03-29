#include <bits/stdc++.h>
#include<iostream>
#include<regex>
using namespace std;


int cntDP(int fir, int sec) {

    int dp[16][16] = {};
    dp[0][1] = 1;
    for (int i = 1; i < 16; i++) {
        for (int j = 1; j < 16; j++) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
    }

    return dp[fir][sec];
}


int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, K;
    cin >> N >> M >> K;
    int fir = K / M;     //1
    int sec = K % M;     //3

    if (K == 0) {
        cout << cntDP(N, M) << endl;;
    }
    else {
        int fx, fy, sx, sy;
        fx = K / M + (K % M > 0 ? 1 : 0);
        fy = K - (fx - 1) * M;
        sx = N - fx + 1;
        sy = M - fy + 1;
        cout << cntDP(fx, fy) * cntDP(sx, sy) << endl;
    }

    return 0;
}
 