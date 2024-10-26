#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int main()
{
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);

    for (int i = 0; i < 4; i++) {
        int x1, x2, x3, x4, y1, y2, y3, y4;

        int xl, xr, yb, yt;

        cin >> x1 >> y1 >> x2 >> y2 >> x3 >> y3 >> x4 >> y4;

        xl = max(x1, x3);
        xr = min(x2, x4);
        yb = max(y1, y3);
        yt = min(y2, y4);

        if ((xr - xl) > 0 && (yt - yb) > 0) {
            cout << 'a' << endl;
        }
        else if ((xr - xl) < 0 || (yt - yb) < 0) {
            cout << 'd' << endl;
        }
        else if ((xr - xl) == 0 && (yt - yb) == 0) {
            cout << 'c' << endl;
        }
        else {
            cout << 'b' << endl;
        }
    }

    return 0;
}