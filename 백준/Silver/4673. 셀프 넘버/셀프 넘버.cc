#include <bits/stdc++.h>
#include<iostream>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);


    vector<int> num(10001, 0);
    for (int i = 1; i <= 10000; i++) {
        int checknum = i;
        int tmp = i;
        while (true) {
            if (checknum >= 10) {
                tmp += checknum % 10;
                checknum /= 10;
            }
            else {
                tmp += checknum;
                break;
            }
        }
        if (tmp <= 10000) {
            num[tmp]++;
        }
    }
    for (int i = 1; i <= 10000; i++) {
        if (num[i] == 0) {
            cout << i << endl;
        }
    }
    return 0;
}