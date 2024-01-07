import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long dp[] = new long[101];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        dp[5] = 5;
        for(int i=6; i<=100; i++) {
        	for(int j=3; j<i; j++) {
        		dp[i] = Math.max(dp[i], dp[i-j]*(j-1));
        	}
        }
        System.out.println(dp[N]);
	}
}
