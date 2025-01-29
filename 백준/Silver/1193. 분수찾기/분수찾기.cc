#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int main()
{
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int X;
    cin >> X;

    int tmp = 1;

    while (true) {
        if (X > tmp) {
            X -= tmp;
            tmp++;
        }
        else {
            break;
        }
    }
    int fir = tmp - X + 1;
    int sec = X;
    if (tmp % 2 == 1) {
        cout << fir << "/" << sec;
    }
    else {
        cout << sec << "/" << fir;
    }

    return 0;
}