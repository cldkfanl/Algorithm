import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int a = Integer.parseInt(br.readLine());
        if(a == 1) {
        	System.out.println(1);
        }
        else if(a ==2) {
        	System.out.println(3);
        }
        else {
        	long[] dp = new long[a+1];
        	long[] dp2 = new long[a+1];
        	dp[1] = 1;
        	dp[2] = 3;
        	for(int i=3; i<=a; i++) {
        		dp[i] = (dp[i-1] + dp[i-2]*2)%10007;
        	}
        	System.out.println(dp[a]);
        }
    }
}