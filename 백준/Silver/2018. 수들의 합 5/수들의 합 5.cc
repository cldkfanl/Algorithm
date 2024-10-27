#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int main()
{
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);

    int fir = 1, sec = 1, cnt = 1, sum = 1;

    int input;
    cin >> input;

    while (sec != input) {
        if (input == sum) {
            cnt++, sec++;
            sum += sec;
        }
        else if (input < sum) {
            sum -= fir;
            fir++;

        }
        else {
            sec++;
            sum += sec;
        }
    }
    cout << cnt << endl;
    return 0;
}