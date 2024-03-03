#include <bits/stdc++.h>
#include<iostream>
using namespace std;
int arr[1000001];
//유니온파인드 문제

//재귀함수
//파인드
int find(int x) {
    if (arr[x] == x) {
        return x;
    }
    arr[x] = find(arr[x]);
    return arr[x];
}

//유니온
void merge(int x, int y) {
    x = find(x);
    y = find(y);
    if (x == y) {
        return;
    }
    else {
        arr[x] = y;
    }
}


int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    for (int i = 0; i <= 1000000; i++) {
        arr[i] = i;
    }
    int n, m;

    cin >> n >> m;


    for (int i = 0; i < m; i++) {
        int check, a, b;
        cin >> check >> a >> b;
        if (check == 0) {
            merge(a, b);
        }
        else {
            if (find(a) == find(b)) {
                cout << "YES" << "\n";
            }
            else {
                cout << "NO" << "\n";
            }
        }
    }

    return 0;
}
 