#include <bits/stdc++.h>
#include<iostream>
using namespace std;
int arr[21][21][21];



int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    long sum = 0;
    cin >> N;
    vector<int> arr(N);
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
        sum += arr[i];
    }
    int M;
    cin >> M;
    sort(arr.begin(), arr.end());

    if (sum < M) {
        cout << arr[N - 1] << endl;
    }
    else {
        int left = 0;
        int right = arr[N - 1];
        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (mid > arr[i]) {
                    sum += arr[i];
                }
                else {
                    sum += mid;
                }
            }
            if (sum <= M) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        cout << right << endl;
    }
}