#include<iostream>
#include<stack>
using namespace std;



int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, num, tmp, output;
    stack<int> stack;
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> num;
        switch (num) {
        case 1 :
            cin >> tmp;
            stack.push(tmp);
            break;
        case 2 :
            if (stack.empty()) {
                cout << -1 << "\n";
            }
            else {
                cout << stack.top() << "\n";
                stack.pop();
            }
            break;
        case 3 :
            cout << stack.size() << "\n";
            break;
        case 4 :
            if (stack.empty()) {
                cout << 1 << "\n";
            }
            else {
                cout << 0 << "\n";
            }
            break;
        case 5 :
            if (stack.empty()) {
                cout << -1 << "\n";
            }
            else {
                cout << stack.top() << "\n";
            }
            break;
        }
    }
}
