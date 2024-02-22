#include <bits/stdc++.h>
#include<iostream>
using namespace std;

//그리디



int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N, K;
    cin >> N >> K;
    int output;
    for (int i = 0; ; i++) {
        int tmp = N + i;
        int cnt = 0;

        while (tmp != 0) {
            if (tmp % 2 == 1) {
                cnt++;
            }
            tmp /= 2;
        }
        if (cnt <= K) {
            output = i;
            break;
        }
    }
    
    cout << output << endl;
    return 0;
}
 