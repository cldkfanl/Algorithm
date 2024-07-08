#include <vector>
#include<iostream>
using namespace std;


int main()
{
    vector<bool> arr(1000001, true);
    for (int i = 2; i*i <= 1000000; i++) {
        for (int j = i * i; j <= 1000000; j += i) {
            arr[j] = false;
        }
    }
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);

    while (true) {
        int n;
        cin >> n;
        if (n == 0) {
            break;
        }
        for (int i = 3; i <= n; i+=2) {
            if (arr[i] && arr[n - i]) {
                cout << n << " = " << i << " + " << n - i << '\n';
                break;
            }
        }
    }

    return 0;
}