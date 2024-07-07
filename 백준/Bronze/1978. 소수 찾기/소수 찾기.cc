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
    vector<bool> arr(1001, true);
    arr[1] = false;
    for (int i = 4; i <= 1000; i++) {
        for (int j = 2; j <= sqrt(i); j++) {
            if (i % j == 0) {
                arr[i] = false;
                break;
            }
        }
    }
    int cnt = 0;
    for (int i = 0; i < N; i++) {
        int tmp;
        cin >> tmp;
        if(arr[tmp]){
            cnt++;
        }
    }
    cout << cnt << endl;
    return 0;
}