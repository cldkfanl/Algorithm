#include<iostream>
#include<deque>
using namespace std;



int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    deque<int> deq;
    int N, M;
    cin >> N;
    bool flag[100001];
    for (int i = 0; i < N; i++) {
        cin >> flag[i];
    }
    for (int i = 0; i < N; i++) {
        int x;
        cin >> x;
        if (!flag[i]) {
            deq.push_back(x);
        }
    }
    cin >> M;

    for (int i = 0; i < M; i++) {
        int y;
        cin >> y;
        deq.push_front(y);
        cout << deq.back() << " ";
        deq.pop_back();
    }

    return 0;
}
