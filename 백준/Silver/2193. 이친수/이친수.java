import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main  {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        long dp[] = new long[a+2];
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i<= a; i++) {
        	dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[a]);
    }
}