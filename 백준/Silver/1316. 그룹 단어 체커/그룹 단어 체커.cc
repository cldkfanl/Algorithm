#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N;
    cin >> N;
    int size = 0;
    for (int i = 0; i < N; i++) {
        string input;
        cin >> input;
        bool state = false;
        int arr[26] = {};
        for (int j = 0; j < input.length()-1; j++) {
            arr[input[j] - 'a']++;
            if (input[j] != input[j + 1]) {
                if (arr[input[j + 1] - 'a'] > 0) {
                    state = true;
                    break;
                }
            }
        }
        if (!state) {
            size++;
        }
    }
    cout << size << endl;

    return 0;
}