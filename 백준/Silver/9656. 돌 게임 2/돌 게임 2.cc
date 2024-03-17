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

    int arr[1001] = {};

    arr[1] = 0;
    arr[2] = 1;
    arr[3] = 0;
    for (int i = 4; i <= 1000; i++) {
        if (arr[i - 1] == 0 || arr[i - 3] == 0) {
            arr[i] = 1;
        }
        else {
            arr[i] = 0;
        }
    }
    if (arr[N] == 1) {
        cout << "SK" << endl;
    }
    else {
        cout << "CY" << endl;
    }

    return 0;
}
 