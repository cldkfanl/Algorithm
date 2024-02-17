#include <bits/stdc++.h>
#include<iostream>
using namespace std;


int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    vector<int> V;
    cin >> N;

    for (int i = 0; i < N; i++) {
        int input;
        cin >> input;
        V.push_back(input);
    }
    sort(V.rbegin(), V.rend());

    int day = 0;

    for (int i = 0; i < V.size(); i++) {
        day = max(day, V[i] + i + 2);
    }

    cout << day << endl;
    

    return 0;
}
 