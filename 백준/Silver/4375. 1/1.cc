#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n;

    while (cin >> n) {
        long cmp = 1;
        int cnt = 1;
        while (true) {
            if (cmp % n == 0) {
                cout << cnt << endl;
                break;
            }
            else {
                cmp = cmp * 10 + 1;
                cmp %= n;
                cnt++;
            }
        }
    }



    return 0;
}