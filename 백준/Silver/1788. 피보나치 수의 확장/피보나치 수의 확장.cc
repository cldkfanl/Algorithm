#include<iostream>
#include<queue>
#include<algorithm>
using namespace std;


long long dp[1000001];

int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= 1000000; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
        dp[i] = dp[i] % 1000000000;
    }
    int n;
    cin >> n;

    if (n == 0) {
        cout << 0 << "\n";
        cout << 0 << "\n";
    }
    else if (n > 0) {
        cout << 1 << "\n";
        cout << dp[n] << "\n";
    }
    else {
        int tmp = abs(n);
        if (n % 2 == 0) {
            cout << -1 << "\n";
            cout << dp[tmp] << "\n";
        }
        else {
            cout << 1 << "\n";
            cout << dp[tmp] << "\n";
        }
    }

    return 0;
}
