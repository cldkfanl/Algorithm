#include <bits/stdc++.h>
#include<iostream>
using namespace std;

int cnt = 0;
int N;

void calc(int num) {
    if (cnt != 0 && num == N) {
        return;
    }
    int fir = num / 10;
    int sec = num % 10;
    int thr = fir + sec;
    cnt++;
    calc(thr % 10 + sec * 10);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    calc(N);
    cout << cnt << endl;
    return 0;
}