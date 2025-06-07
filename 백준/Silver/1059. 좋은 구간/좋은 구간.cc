#include <bits/stdc++.h>
#include<iostream>

using namespace std;


int main()
{
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int L, n;

    cin >> L;

    std::vector<int> vec_s;

    int tmp, start = 0, end = 0;
    for (int i = 0; i < L; i++) {
        cin >> tmp;
        vec_s.emplace_back(tmp);
    }
    sort(vec_s.begin(), vec_s.end());
    cin >> n;

    if (binary_search(vec_s.begin(), vec_s.end(), n)) {
        cout << 0;
        return 0;
    }

    for(int i=0; i<L; i++){
        if (vec_s[i] > n) {
            end = vec_s[i] - 1;
            if (i == 0) start = 1;
            else start = vec_s[i - 1] + 1;
            break;
        }
    }
    if (start > n || end < n) {
        cout << 0;
    }
    else {
        int result = (n - start) * (end - n + 1) + (end - n);
        cout << result;
    }


    return 0;
}