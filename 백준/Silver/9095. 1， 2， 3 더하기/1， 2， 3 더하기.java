import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        for(int i=0; i<a; i++) {
        	int input = Integer.parseInt(br.readLine());
        	int[] dp = new int[input+3];
        	dp[1] = 1;
        	dp[2] = 2;
        	dp[3] = dp[1] + dp[2] + 1;
        	for(int j=4; j<=input; j++) {
        		dp[j] = (dp[j-1] + dp[j-2] + dp[j-3]);
        	}
        	System.out.println(dp[input]);
        }
    }
}