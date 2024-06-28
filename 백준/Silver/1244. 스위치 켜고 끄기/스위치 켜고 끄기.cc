#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, P;
    cin >> N;
    vector<int> arr(N + 1);
    for (int i = 1; i <= N; i++) {
        int input;
        cin >> input;
        arr[i] = input;
    }
    cin >> P;
    for (int i = 0; i < P; i++) {
        int fir, sec;
        cin >> fir >> sec;
        if (fir == 1) {
            for (int j = sec; j <= N; j += sec) {
                arr[j] = abs(arr[j] - 1);
            }
        }
        else {
            arr[sec] = abs(arr[sec] - 1);
            int tmp1 = sec-1, tmp2 = sec+1;
            while (true) {
                if (tmp1 <= 0 || tmp2 > N) {
                    break;
                }
                if (arr[tmp1] != arr[tmp2]) {
                    break;
                }
                arr[tmp1] = abs(arr[tmp1] - 1);
                arr[tmp2] = abs(arr[tmp2] - 1);
                tmp1--;
                tmp2++;
            }
        }
    }
    for (int i = 1; i <= N; i++) {
        cout << arr[i] << " ";
        if (i % 20 == 0) {
            cout << endl;
        }
    }
}