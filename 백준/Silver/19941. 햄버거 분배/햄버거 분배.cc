#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, K;
    int arr[20001];
    memset(arr, 0, sizeof(arr));
    cin >> N >> K;

    string input;

    cin >> input;
    for (int i = 0; i < N; i++) {
        char tmp;
        tmp = input[i];

        if (tmp == 'H') {
            arr[i] = 2;
        }
        else {
            arr[i] = 1;
        }
    }
    int cnt = 0;
    for (int i = 0; i < N; i++) {
        if (arr[i] == 1) {
            for (int j = i-K; j <=i +  K; j++) {
                if (j >= 0 && j <= 20000 && arr[j] == 2) {
                    arr[j] = 0;
                    cnt++;
                    break;
                }
            }
        }
    }

    cout << cnt << endl;

    return 0;
}
 