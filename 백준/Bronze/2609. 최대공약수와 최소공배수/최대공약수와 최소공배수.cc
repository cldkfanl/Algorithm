#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int calc(int x, int y) {
    if (y == 0) {
        return x;
    }
    return calc(y, x % y);
}


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);


    int fir, sec;
    cin >> fir >> sec;
    int tmp1 = calc(fir, sec);
    int tmp2 = fir * sec / tmp1;
    cout << tmp1 << endl;
    cout << tmp2 << endl;

    return 0;
}