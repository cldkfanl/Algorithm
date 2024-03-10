#include <bits/stdc++.h>
#include<iostream>
using namespace std;

vector<int> arr;


//이분탐색

int max_len(int size, int C) {
    //초기값 설정, 끝과 끝으로
    int fir_dist = 1;
    int last_dist = arr[size -1] - arr[0];

    int res_dist = 0;

    while (fir_dist <= last_dist) {
        //첫째 집은 무조건 공유기 설치
        int cnt = 1;

        //갱신주기
        int mid_dist = (fir_dist + last_dist) / 2;

        int start = arr[0];

        for (int i = 1; i < size; i++) {
            int end = arr[i];
            //갱신주기 만족 시 공유기 설치
            if (end - start >= mid_dist) {
                cnt++;
                start = end;
            }
        }

        //설치 수 초과 시
        if (cnt >= C) {
            //간격 늘림
            res_dist = mid_dist;
            fir_dist = mid_dist+1;
        }
        //설치 수 미달 시
        else {
            //간격 줄임
            last_dist = mid_dist-1;
        }

    }
    return res_dist;
}



int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, C;
    cin >> N >> C;

    for (int i = 0;i < N; i++) {
        int tmp;
        cin >> tmp;
        arr.push_back(tmp);
    }
    sort(arr.begin(), arr.end());

    cout << max_len(N, C) << endl;


    return 0;
}
 