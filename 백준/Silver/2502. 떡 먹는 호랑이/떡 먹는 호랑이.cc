#include <bits/stdc++.h>
#include<iostream>
using namespace std;

int D, K;

int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> D >> K;

    int fir[31] = {};

    int sec[31] = {};

    fir[1] = 1;
    fir[2] = 0;
    sec[2] = 1;
    for (int i = 3; i <= 30; i++) {
        fir[i] = fir[i - 1] + fir[i - 2];
        sec[i] = sec[i - 1] + sec[i - 2];
    }

    int tmp1 = 1, tmp2 = 1;

    for (int i = 1; i <= 100000; i++) {
        for (int j = 1; j <= i; j++) {
            if (i * sec[D] + j * fir[D] == K) {
                cout << j << endl;
                cout << i << endl;
                return 0;
            }
        }
    }

    return 0;
}
 