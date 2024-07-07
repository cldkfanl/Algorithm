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
    vector<int> arr;
    for (int i = 0; i < N; i++) {
        int input;
        cin >> input;
        arr.push_back(input);
    }
    sort(arr.begin(), arr.end());
    cout << arr[0] * arr[N - 1] << endl;
    return 0;
}