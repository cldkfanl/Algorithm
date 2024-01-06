import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        long dp[][] = new long[N][21];
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0][arr[0]] = 1;
        for(int i=1; i<N; i++) {
        	for(int j=0; j<=20; j++) {
        		if(dp[i-1][j] > 0) {
        			int plus = j + arr[i];
        			int minus = j - arr[i];
        			if(plus <=20) {
        				dp[i][plus] += dp[i-1][j];
        			}
        			if(minus >= 0) {
        				dp[i][minus] += dp[i-1][j];
        			}
        		}
        	}
        }
        System.out.println(dp[N-2][arr[N-1]]);
	}
}
