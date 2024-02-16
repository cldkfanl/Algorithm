#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, J, tmp;
    cin >> N >> M;
    cin >> J;
    int left = 1;
    int right = M;
    int cnt = 0;
    for (int i = 0; i < J; i++) {
        cin >> tmp;
        if (left > tmp) {
            cnt += left - tmp;
            right -= left - tmp;
            left = tmp;
        }
        else if(tmp > right) {
            cnt += tmp - right;
            left += tmp - right;
            right = tmp;
        }
    }

    cout << cnt << endl;

    return 0;
}
 