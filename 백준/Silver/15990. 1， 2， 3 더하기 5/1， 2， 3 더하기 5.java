import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
    	long[][] dp = new long[100001][4];
    	dp[1][1] = 1;
    	dp[2][2] = 1;
    	dp[3][3] = 1;
    	dp[3][2] = 1;
    	dp[3][1] = 1;
    	for(int j=4; j<=100000; j++) {
    		dp[j][1] = (dp[j-1][2] + dp[j-1][3])%1000000009;
    		dp[j][2] = (dp[j-2][1] + dp[j-2][3])%1000000009;
    		dp[j][3] = (dp[j-3][2] + dp[j-3][1])%1000000009;
    	}
        for(int i=0; i<a; i++) {
        	int input = Integer.parseInt(br.readLine());
        	System.out.println((dp[input][1]+ dp[input][2] + dp[input][3])%1000000009);        }
    }
}