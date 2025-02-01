#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int main()
{
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int N;
    cin >> N;

    string tmp = to_string(N);

    vector<int> arr;
    for (char c : tmp) {
        arr.push_back(c - '0');
    }
    sort(arr.begin(), arr.end(), greater<int>());

    for (int num : arr) {
        cout << num;
    }

    return 0;
}