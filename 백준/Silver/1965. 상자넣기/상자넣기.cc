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
    vector<int> arr(N);
    vector<int> dp(N);
    for (int i = 0; i < N; i++) {
        int input;
        cin >> input;
        arr[i] = input;
        dp[i] = 1;
    }

    for (int i = 1; i < N; i++) {
        for (int j = 0; j < i; j++) {
            if (arr[i] > arr[j]) {
                dp[i] = max(dp[j] + 1, dp[i]);
            }
        }
    }
    sort(dp.begin(), dp.end());
    cout << dp[N - 1] << endl;
}