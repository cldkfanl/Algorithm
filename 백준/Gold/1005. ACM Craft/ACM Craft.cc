#include <bits/stdc++.h>
#include<iostream>
using namespace std;
int T, N, K;
int cost[1001];
std::vector<int> rool[1001];
int target;
int answer[1001];
bool check[1001];

int time_cal(int build) {

    //앞에 지어야 하는 빌딩이 없는 경우
    if (rool[build].size() == 0) {
        return cost[build];
    }

    //값이 이미 계산 되어 있는 경우
    if (check[build]) {
        return answer[build];
    }

    int tmp = 0;
    //이전에 지어야 하는 빌딩들의 필요시간 계산, 최대값 찾기
    for (int i = 0; i < rool[build].size(); i++) {
        tmp = max(tmp, time_cal(rool[build][i]));
    }

    answer[build] = tmp + cost[build];
    check[build] = true;


    //반환
    return answer[build];
}

void quiz() {

    //배열 초기화
    memset(check, false, sizeof(check));
    for (int i = 0; i < 1001; i++) {
        rool[i].clear();
    }

    cin >> N >> K;

    //비용 입력
    for (int i = 0; i < N; i++) {
        cin >> cost[i+1];
    }
    //간선 입력
    for (int i = 0; i < K; i++) {
        int x, y;
        cin >> x >> y;
        rool[y].push_back(x);
    }
    cin >> target;

    cout << time_cal(target) << "\n";

}
int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;

    cin >> T;

    for(int i=0; i<T; i++){
        quiz();
    }

    return 0;
}
 