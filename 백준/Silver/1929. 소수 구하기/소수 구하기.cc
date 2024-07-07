#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int M, N;
    cin >> M >> N;
    vector<bool> arr(1000001, false);
    arr[0] = arr[1] = true;
    for (int i = 2; i * i <= N; i++) {
        if (arr[i]) {
            continue;
        }
        else {
            for (int j = 2; j * i <= N; ++j) {
                arr[i * j] = true;
            }
        }
    }
    for (int i = M; i <= N; i++) {
        if (!arr[i]) {
            cout << i << endl;
        }
    }
    return 0;
}