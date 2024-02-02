#include<iostream>
#include<stack>
#include<queue>
using namespace std;



int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, num;
    int cnt = 1;
    stack<int> st1;
    cin >> N;
    //들어온 숫자가 연속 된 수라면 스킵
    //아니라면 스택에 삽입(두번 째 줄 세움)
    while(N--) {
        cin >> num;
        if (cnt == num) {
            cnt++;
        }
        else {
            st1.push(num);
        }
        //두번째 줄 에서 연속된 숫자라면 뺌
        while (!st1.empty() && st1.top() == cnt) {
            st1.pop();
            cnt++;
        }
    }
    //두번째 줄에 사람이 남아있으면(스택이 비어있지 않으면)
    //Sad 출력, 아니라면 Nice 출력
    if (st1.empty()) {
        cout << "Nice" << endl;
    }
    else {
        cout << "Sad" << endl;
    }

    return 0;
}
