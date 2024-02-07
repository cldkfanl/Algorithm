#include<iostream>
#include<queue>
#include<algorithm>
#include<math.h>
using namespace std;



//최소값 구하려면 n , n+2, n+4...... , n+1, n+3, n+5.....로 나눈다.
int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int T;

    cin >> T;
    for (int i = 0; i < T; i++) {
        int N;
        cin >> N;
        //테스트 케이스 입력
        vector <int> v(N);
        for (int j = 0; j < N; j++) {
            cin >> v[j];
        }
        // 테스트 케이스 정렬
        sort(v.begin() , v.end());
        int result = 0;
        //맨 처음, 맨 끝 차이값 계산
        result = max(result, v[1] - v[0]);
        result = max(result, v[N-1] - v[N-2]);

        //숫자 간의 크기 비교해서 제일 큰 차이 값 구하기
        for (int j = 0; j < N - 2; j++) {
            result = max(result, v[j + 2] - v[j]);
        }
        cout << result << endl;
    }
    return 0;
}
