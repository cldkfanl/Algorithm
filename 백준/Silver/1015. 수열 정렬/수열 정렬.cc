#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int main()
{
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);

    int num, tmp;
    cin >> num;
    vector<pair<int, int>> input;
    for (int i = 0; i < num; i++) {
        cin >> tmp;
        input.push_back(make_pair(tmp, i));
    }

    sort(input.begin(), input.end());

    vector<int> arr(num);
    for (int i = 0; i < num; i++) {
        arr[input[i].second] = i;
    }
    for (auto i : arr) {
        cout << i << ' ';
    }
    return 0;
}