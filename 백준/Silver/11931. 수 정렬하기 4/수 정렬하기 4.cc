#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int main()
{
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);

    int num;
    cin >> num;

    vector<int> arr;

    for (int i = 0; i < num; i++) {
        int tmp;
        cin >> tmp;
        arr.push_back(tmp);
    }

    sort(arr.begin(), arr.end());

    for (int i = arr.size()-1; i >= 0; i--) {
        cout << arr[i] << "\n";
    }


    return 0;
}