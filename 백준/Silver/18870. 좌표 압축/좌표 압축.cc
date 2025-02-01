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
    vector<int> arr;

    for (auto i = 0; i < N; i++) {
        int input;
        cin >> input;
        arr.push_back(input);
    }

    vector<int> cp(arr);

    sort(cp.begin(), cp.end());
    cp.erase(unique(cp.begin(), cp.end()), cp.end());

    for (auto tmp : arr) {
        cout << lower_bound(cp.begin(), cp.end(), tmp) - cp.begin() << " ";
    }
    
    return 0;
}