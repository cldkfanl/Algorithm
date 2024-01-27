#include<iostream>
#include<algorithm>
using namespace std;

int N, M, ans, sum;
int bt[101], cost[101];
int dp[101][10001];

int main() 
{
    cin >> N >> M;

    for (int i = 1; i <= N; i++) cin >> bt[i];
    for (int i = 1; i <= N; i++)
    {
        cin >> cost[i];
        // sum : 모든 비용들의 합
        sum += cost[i];
    }

    for (int i = 1; i <= N; i++) {
        for (int j = 0; j <= sum; j++) {
            if (j - cost[i] >= 0) {
                dp[i][j] = max(dp[i][j], dp[i - 1][j - cost[i]] + bt[i]);
            }
            dp[i][j] = max(dp[i][j], dp[i - 1][j]);
        }
    }
    for (int i = 0; i <= sum; i++) {
        if (dp[N][i] >= M) {
            cout << i << endl;
            break;
        }
    }

        
} 