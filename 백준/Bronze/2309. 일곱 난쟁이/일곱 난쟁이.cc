#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int main()
{
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);

    vector<int> arr(9);
    int sum = 0;
    for (int i = 0; i < 9; i++) {
        cin >> arr[i];
        sum += arr[i];
    }
    sort(arr.begin(), arr.end());
    bool check = false;
    for (int i = 0; i < 9; i++) {
        for (int j = i + 1; j < 9; j++) {
            if (sum - arr[i] - arr[j] == 100 && !check) {
                arr[i] = arr[j] = 0;
                check = true;
            }
        }
    }

    for (int i = 0; i < 9; i++) {
        if (arr[i] > 0) {
            cout << arr[i] << endl;
        }
    }

    return 0;
}