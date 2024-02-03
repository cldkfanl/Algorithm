#include<iostream>
#include<deque>
using namespace std;



int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    deque<int> deq;
    int N, num, tmp;
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> num;
        switch (num) {
        case 1:
            cin >> tmp;
            deq.push_front(tmp);
            break;
        case 2:
            cin >> tmp;
            deq.push_back(tmp);
            break;
        case 3:
            if (!deq.empty()) {
                cout << deq.front() << "\n";
                deq.pop_front();
            }
            else {
                cout << -1 << "\n";
            }
            break;
        case 4:
            if (!deq.empty()) {
                cout << deq.back() << "\n";
                deq.pop_back();
            }
            else {
                cout << -1 << "\n";
            }
            break;
        case 5:
            cout << deq.size() << "\n";
            break;
        case 6:
            if (deq.empty()) {
                cout << 1 << "\n";
            }
            else {
                cout << 0 << "\n";
            }
            break;
        case 7 :
            if (!deq.empty()) {
                cout << deq.front() << "\n";
            }
            else {
                cout << -1 << "\n";
            }
            break;
        case 8 :
            if (!deq.empty()) {
                cout << deq.back() << "\n";
            }
            else {
                cout << -1 << "\n";
            }
            break;

        }
    }

    return 0;
}
