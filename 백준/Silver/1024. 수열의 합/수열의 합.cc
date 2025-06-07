#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int main()
{
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int N, L;
    cin >> N >> L;
    
    int i_start = -1, i_cnt = 0;

    for (int i = L; i <= 100; i++) {
        int t = i * (i - 1) / 2;

        if ((N - t) % i == 0 && (N - t) / i >= 0) {
            i_start = (N - t) / i;
            i_cnt = i;
            break;
        }
    }

    if (i_start < 0) {
        printf("%d\n", i_start);
        return 0;
    }

    for (int i = 0; i < i_cnt; i++)
    {
        printf("%d ", i_start + i);
    }
    printf("\n");
    return 0;



    return 0;
}