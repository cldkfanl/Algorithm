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
    vector<int> up(N);
    vector<int> down(N);
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
        up[i] = 1;
        down[i] = 1;
    }

    for (int i = 1; i < N; i++) {
        if (arr[i] >= arr[i - 1]) {
            up[i] = up[i - 1] + 1;
        }
    }
    for (int i = N - 2; i >= 0; i--) {
        if (arr[i] >= arr[i + 1]) {
            down[i] = down[i + 1] + 1;
        }
    }

    int upnum = 0;
    int downnum = 0;


    for (int i = 0; i < N; i++) {
        upnum = max(upnum, up[i]);
        downnum = max(downnum, down[i]);
    }
    cout << max(upnum, downnum) << endl;



    return 0;
}