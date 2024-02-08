#include <bits/stdc++.h>
#include<iostream>
#include<algorithm>
#include<math.h>
using namespace std;


bool arr[10][10], tmparr[10][10];
//나머지용
int fx[5] = { 0, 1,1,1,2 };
int fy[5] = { 0,-1,0,1,0 };

//첫줄용
int x[4] = { 0,0,0,1 };
int y[4] = { -1,0,1,0 };

int cmp = 1000000000;


// 모든 칸이 #인지 검사
bool check() {
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            if (tmparr[i][j]) {
                return false;
            }
        }
    }
    return true;
}
void greedy(int cnt) {

    // 그리디 진행
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 10; j++) {
            //'O' 이면 그 칸, 밑 3칸 , 밑 1칸 '#'으로 변경
            if (tmparr[i][j]) {
                for (int k = 0; k < 5; k++) {
                    int nx = fx[k] + i;
                    int ny = fy[k] + j;

                    if (nx >= 0 && nx < 10 && ny >= 0 && ny < 10) {
                        tmparr[nx][ny] = abs(tmparr[nx][ny] -1);
                    }
                }
                cnt++;
            }
        }
    }
    if (check()) {
        cmp = min(cnt, cmp);
    }
}

//첫번째 줄 클릭하는 함수
void fClick(int xx) {
    for (int i = 0; i < 4; i++) {
        int nx = x[i];
        int ny = xx + y[i];
        if (nx >= 0 && nx < 10 && ny >= 0 && ny < 10) {
            tmparr[nx][ny] = abs(tmparr[nx][ny] - 1);
        }
    }
}
//배열 복사하는 함수
void init() {
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            tmparr[i][j] = arr[i][j];
        }
    }
}
int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);


    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            char c;
            cin >> c;
            if (c == 'O') {
                arr[i][j] = 1;
            }
        }
    }
    //비트마스킹을 통해 첫번 째 줄 브루트포스 진행.
    //모든 경우의 수를 진행. 총 경우의 수는 2^10(1024)
    for (int i = 0; i < (1 << 10); i++) {
        int cnt = 0;
        init();
        for (int j = 0; j < 10; j++) {
            if (i & (1 << j)) {
                cnt++;
                fClick(j);
            }
        }
        //두번째 줄부터 끝 까지 greedy 진행
        greedy(cnt);
    }
    

    
    if (cmp == 1000000000) {
        cout << -1 << endl;
    }
    else {
        cout << cmp << endl;
    }


    return 0;
}
