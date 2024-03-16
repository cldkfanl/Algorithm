#include <bits/stdc++.h>
#include<iostream>
using namespace std;

//구현
//초기화를 잘 하자
int gear[4][8] = {};
int rotation[5];
bool check[5];


void spin_right(int num) {
    int tmp = gear[num - 1][7];
    for (int i = 7; i > 0; i--) {
        gear[num - 1][i] = gear[num - 1][i - 1];
    }
    gear[num - 1][0] = tmp;
}
void spin_left(int num) {
    int tmp = gear[num - 1][0];
    for (int i = 0; i < 7; i++) {
        gear[num - 1][i] = gear[num - 1][i + 1];
    }
    gear[num - 1][7] = tmp;
}

void setRotation(int fir, int sec) {
    rotation[fir] = sec;
    check[fir] = true;

    if (fir - 1 > 0 && !check[fir - 1]) {
        if (sec == 0) {
            setRotation(fir - 1, 0);
        }
        else if (gear[fir-1][6] == gear[fir - 2][2]) {
            setRotation(fir - 1, 0);
        }
        else {
            setRotation(fir - 1, -sec);
        }
    }

    if (fir + 1 <= 4 && !check[fir + 1]) {
        if (sec == 0) {
            setRotation(fir + 1, 0);
        }
        else if (gear[fir-1][2] == gear[fir][6]) {
            setRotation(fir + 1, 0);
        }
        else {
            setRotation(fir + 1, -sec);
        }
    }
}

void spin() {
    for (int i = 1; i <= 4; i++) {
        if (rotation[i] == 0) {
            continue;
        }
        else if (rotation[i] == 1) {
            spin_right(i);
        }
        else {
            spin_left(i);
        }
    }
}



int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);


    for (int i = 0; i < 4; i++) {
        string input;
        cin >> input;
        for (int j = 0; j < 8; j++) {
            gear[i][j] = (int)(input[j] - '0');

        }
    }

    int K;

    cin >> K;

    for (int i = 0; i < K; i++) {
        int fir, sec;
        cin >> fir >> sec;
        setRotation(fir, sec);
        for (int j = 0; j < 5; j++) {
            check[j] = false;
        }
        spin();
    }
    int sum = 0;
    for (int i = 0; i < 4; i++) {
        sum += gear[i][0] * pow(2, i);
    }

    cout << sum << endl;

    return 0;
}
 