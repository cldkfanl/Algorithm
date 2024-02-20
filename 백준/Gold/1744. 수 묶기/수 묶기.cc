#include <bits/stdc++.h>
#include<iostream>
using namespace std;

//그리디
//0보다 큰 경우 위에서 부터, 인자가 1인 경우 제외
//0보다 작은 경우 아래에서 부터.


int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    priority_queue<int, vector<int>, less<int>> pqPlus;
    priority_queue<int, vector<int>, greater<int>> pqMinus;

    int N;
    cin >> N;

    for (int i = 0; i < N; i++) {
        int tmp;
        cin >> tmp;
        if (tmp > 0) {
            pqPlus.push(tmp);
        }
        else {
            pqMinus.push(tmp);
        }
    }

    long sum = 0;
    int fir = 0, sec = 0;
    if (pqPlus.size() % 2 == 0) {
        while (!pqPlus.empty()) {
            fir = pqPlus.top();
            pqPlus.pop();
            sec = pqPlus.top();
            pqPlus.pop();
            if (fir == 1 || sec == 1) {
                sum += fir + sec;
            }
            else {
                sum += fir * sec;
            }
        }
    }
    else {
        while (pqPlus.size() != 1) {
            fir = pqPlus.top();
            pqPlus.pop();
            sec = pqPlus.top();
            pqPlus.pop();
            if (fir == 1 || sec == 1) {
                sum += fir + sec;
            }
            else {
                sum += fir * sec;
            }
        }
        sum += pqPlus.top();
    }
    if (pqMinus.size() % 2 == 0) {
        while (!pqMinus.empty()) {
            fir = pqMinus.top();
            pqMinus.pop();
            sec = pqMinus.top();
            pqMinus.pop();
            sum += fir * sec;
        }
    }
    else{
        while (pqMinus.size() != 1) {
            fir = pqMinus.top();
            pqMinus.pop();
            sec = pqMinus.top();
            pqMinus.pop();
            sum += fir * sec;
        }
        sum += pqMinus.top();
    }
    cout << sum << endl;
    
    return 0;
}
 