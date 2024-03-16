#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, K;
    
    cin >> N >> K;

    vector<vector<int>> arr(N, vector<int>(4));

    int cmp;
    for (int i = 0; i < N; i++) {
        cin >> arr[i][0];
        if (K == arr[i][0]) {
            cmp = i;
        }
        for (int j = 1; j < 4; j++) {
            cin >> arr[i][j];
        }
    }
    int cnt = 0;
    for (int i = 0; i < arr.size(); i++) {
        if (arr[cmp][1] < arr[i][1]) {
            cnt++;
        }
        else if (arr[cmp][1] == arr[i][1]) {
            if (arr[cmp][2] < arr[i][2]) {
                cnt++;
            }
            else if (arr[cmp][2] == arr[i][2]) {
                if (arr[cmp][3] < arr[i][3]) {
                    cnt++;
                }
            }
        }
    }

    cout << cnt + 1;

    return 0;
}
 