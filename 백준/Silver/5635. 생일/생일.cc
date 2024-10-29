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
    string name;
    int day, month, year;
    vector<pair<string,tuple<int, int, int>>> arr;

    for (int i = 0; i < num; i++) {
        cin >> name >> day >> month >> year;
        arr.push_back(make_pair(name, make_tuple(year, month, day)));
    }

    sort(arr.begin(), arr.end(), [](const auto& a, const auto& b) {
        return a.second > b.second;
    });

    cout << arr[0].first<< endl;
    cout << arr[arr.size() - 1].first << endl;


    return 0;
}