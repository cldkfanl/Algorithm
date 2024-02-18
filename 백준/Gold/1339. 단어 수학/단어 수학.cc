#include <bits/stdc++.h>
#include<iostream>
using namespace std;

//그리디
//모든 알파벳의 자릿수 값을 더한다.
//배열 내림차순 정렬 후 값 곱해서 출력.
int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);


    int arr[26] = {};
    int N;
    cin >> N;

    for (int i = 0; i < N; i++) {
        string input;
        cin >> input;
        int v = 1;
        for (int j = input.size() - 1; j >= 0; j--) {
            arr[input[j] - 'A'] += v;
            v *= 10;
        }
    }
    sort(arr, arr + 26, greater<int>());

    int sum = 0;
    for (int i = 0; i < 10; i++) {
        sum += arr[i] * (9 - i);
    }
    cout << sum << endl;
   
    
    return 0;
}
 