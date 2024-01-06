import java.io.*;
import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        int arr[][] = new int[10][2];
        for(int i=0; i<X.length(); i++){
            arr[Integer.parseInt(X.substring(i,i+1))][0] ++;
        }
        for(int i=0; i<Y.length(); i++){
            arr[Integer.parseInt(Y.substring(i,i+1))][1] ++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--){
            int nummin = Math.min(arr[i][0], arr[i][1]);
            for(int j=0; j<nummin; j++){
                sb.append(i);
            }
        }
        String answer = sb.toString();
        if(answer.isEmpty()){
            answer = "-1";
        }
        if(answer.startsWith("0")){
            answer = "0";
        }
        return answer;
    }
}