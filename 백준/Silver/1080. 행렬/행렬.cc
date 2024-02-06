#include<iostream>
#include<queue>
#include<algorithm>
#include<math.h>
using namespace std;




int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int arrA[51][51];
    int arrB[51][51];
    int N, M;

    cin >> N >> M;

    //배열 A 입력
    for (int i = 0; i < N; i++) {
        string input;
        cin >> input;
        for (int j = 0; j < M; j++) {
            arrA[i][j] = input[j] - '0';
        }
    }
    // 배열 B 입력
    for (int i = 0; i < N; i++) {
        string input;
        cin >> input;
        for (int j = 0; j < M; j++) {
            arrB[i][j] = input[j] - '0';
        }
    }
    int cnt = 0;

    //그리디
    for (int i = 0; i < N - 2; i++) {
        for (int j = 0; j < M - 2; j++) {

            //숫자가 같지 않다면
            if (arrA[i][j] != arrB[i][j]) {
                //3*3 의 칸의 값을 뒤집는다.
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        arrA[i + k][j + l] = abs(arrA[i + k][j + l] - 1);
                    }
                }
                cnt++;
            }
        }
    }
    bool check = true;

    // 배열 비교
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (arrA[i][j] != arrB[i][j]) {
                check = false;
                break;
            }
        }
    }
    if (!check) {
        cout << -1 << endl;
    }
    else {
        cout << cnt << endl;
    }
    return 0;
}
