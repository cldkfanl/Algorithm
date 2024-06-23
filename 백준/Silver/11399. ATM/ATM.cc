#include <bits/stdc++.h>
#include<iostream>
using namespace std;

int fy[4] = { 0,1,0,-1 };
int fx[4] = { -1,0,1,0 };

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
    int cnt = arr.size();
    sort(arr.begin(), arr.end());
    long sum = 0;
    for (int i = 0; i < N; i++) {
        sum += arr[i] * cnt;
        cnt--;
    }
    cout << sum << endl;
    return 0;
}