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
    int cnt = 0;
    for (int i = 1; i <= N; i++) {
        if (i < 100) {
            cnt++;
        }
        else {
            int fir = i % 10;
            int sec = (i / 10) % 10;
            int thr = i / 100;
            if ((fir - sec) == (sec - thr)) {
                cnt++;
            }
        }
    }
    cout << cnt << endl;

    return 0;
}