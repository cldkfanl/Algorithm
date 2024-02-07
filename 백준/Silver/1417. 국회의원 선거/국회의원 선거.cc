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
    int N, ds;
    cin >> N >> ds;
    if (N == 1) {
        cout << 0 << endl;
    }
    else {
        vector <int> v(N - 1);
        for (int i = 0; i < N - 1; i++) {
            cin >> v[i];
        }
        sort(v.begin(), v.end());
        int cnt = 0;
        while (ds <= v[N - 2]) {
            ds++;
            v[N - 2]--;
            cnt++;
            sort(v.begin(), v.end());
        }
        cout << cnt << endl;
    }
    return 0;
}
