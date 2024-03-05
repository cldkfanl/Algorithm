#include <bits/stdc++.h>
#include<iostream>
using namespace std;
//우선순위 큐

priority_queue<int> pq_fir;  //절반 이하 작은 값
priority_queue<int, vector<int>, greater<int>> pq_sec; //절반 이상 큰 값



int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    


    int N;
    cin >> N;

    int tmp;
    cin >> tmp;
    pq_fir.push(tmp);
    cout << tmp << "\n";


    for (int i = 1; i < N; i++) {
        cin >> tmp;
        if (pq_fir.top() < tmp) {
            pq_sec.push(tmp);
        }
        else {
            pq_fir.push(tmp);
        }

        if (pq_fir.size() == pq_sec.size() + 2) { //작은쪽이 두개 더 클 때
            int tmp_fir = pq_fir.top(); //왼쪽 꺼 빼서
            pq_fir.pop();
            pq_sec.push(tmp_fir); //오른쪽으로
        }
        else if (pq_fir.size() < pq_sec.size()) { //오른쪽이 클 때
            int tmp_sec = pq_sec.top();
            pq_sec.pop();
            pq_fir.push(tmp_sec); //왼쪽으로 옮김
        }
        
        cout << pq_fir.top() << "\n";
    }

    return 0;
}
 