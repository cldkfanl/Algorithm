#include <string>
#include <vector>
#include<iostream>
#include <bits/stdc++.h>
using namespace std;

int solution(string s) {
    vector<string> arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    int answer = 0;
    for(int i=0; i<10; i++){
        size_t pos = s.find(arr[i]);
        while(pos != string::npos){
            s.replace(pos, arr[i].length(), to_string(i));
            pos = s.find(arr[i], pos+1);
        }
    }
    answer = stoi(s);
    return answer;
}