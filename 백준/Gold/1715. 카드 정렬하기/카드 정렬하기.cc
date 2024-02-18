#include <bits/stdc++.h>
#include<iostream>
using namespace std;

//우선순위 큐 사용.
//제일 작은 값 두개 꺼내서 더하고 넣기. 반복
int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    priority_queue<int, vector<int>, greater<int>> pq;
    for (int i = 0; i < N; i++) {
        int tmp;
        cin >> tmp;
        pq.push(tmp);
    }
    int output = 0;
    while (N-- > 1) {
        int fir = pq.top();
        pq.pop();
        int sec = pq.top();
        pq.pop();
        int sum = fir + sec;
        output += sum;
        pq.push(sum);
    }
    cout << output << endl;
   
    
    return 0;
}
 