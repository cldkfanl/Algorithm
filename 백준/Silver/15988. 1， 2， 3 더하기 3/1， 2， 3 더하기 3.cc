#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    

    long arr[1000001];
    arr[1] = 1;
    arr[2] = 2;
    arr[3] = 4;
    for (int i = 4; i < 1000001; i++) {
        arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1];
        arr[i] %= 1000000009;
    }

    int T, n;
    cin >> T;
    for (int i = 0; i < T; i++) {
        cin >> n;
        cout << arr[n] << endl;
    }

    return 0;
}