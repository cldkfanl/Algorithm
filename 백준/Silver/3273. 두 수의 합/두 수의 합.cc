#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, x;
    cin >> n;
    vector<int> arr(n);
    for (int i = 0; i < n; i++) {
        int tmp;
        cin >> tmp;
        arr[i] = tmp;
    }
    sort(arr.begin(), arr.end());
    cin >> x;
    int cnt = 0;
    int left = 0;
    int right = n - 1;
    while (left < right) {
        int tmp = arr[left] + arr[right];
        if (tmp == x) {
            cnt++;
        }
        if (tmp <= x) {
            left++;
        }
        else {
            right--;
        }
    }
    cout << cnt << endl;
}