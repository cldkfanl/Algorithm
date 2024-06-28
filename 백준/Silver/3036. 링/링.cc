#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int check(int fir, int sec) {
    if (fir % sec == 0) {
        return sec;
    }
    else {
        return check(sec, fir % sec);
    }
}


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;
    vector<int> arr(N);
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }
    for (int i = 1; i < N; i++) {
        int num = check(arr[0], arr[i]);
        cout << arr[0] / num << "/" << arr[i] / num << endl;
    }
}