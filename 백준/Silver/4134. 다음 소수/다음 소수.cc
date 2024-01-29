#include<iostream>
#include<cmath>
using namespace std;



int main() 
{
    long long tc, n, m, output;
    cin >> tc;
    for(int i = 0; i < tc; i++){
        cin >> n;
        bool p = (n < 3) ? 1 : 0;
        output = (n < 3) ? 2 : n;

        while (!p) {
            m = sqrt(n) + 1;
            for (int i = 2; i <= m; i++) {
                if (n % i == 0) {
                    break;
                }
                if (i == m) {
                    output = n;
                    p = 1;
                }
            }
            n++;
        }
        cout << output << '\n';
    }
}
