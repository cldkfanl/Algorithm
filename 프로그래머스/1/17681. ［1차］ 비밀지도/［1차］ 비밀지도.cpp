#include <string>
#include <vector>
#include<iostream>
#include <bits/stdc++.h>
using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer(n,"");
    for(int i=0; i<n; i++){
        int cmp = pow(2,n-1);
        for(int j=0; j<n; j++){
            if(arr1[i] < cmp && arr2[i] < cmp){
            answer[i] += " ";
            }
            else{
                if(arr1[i] >= cmp){
                    arr1[i] -= cmp;
                }
                if(arr2[i] >= cmp){
                    arr2[i] -= cmp;
                }
                answer[i] += "#";
            }
        cmp /= 2;
        }
    }
    return answer;
}