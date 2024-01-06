import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb= new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long dp[] = new long[5001];
        dp[0] = 1;
        dp[2] = 1;
        for(int i=4; i<=5000; i+=2) {
        	long cnt = 0;
        	int cmp = i-2;
        	for(int j=0; j<=cmp; j+=2) {
        		cnt += dp[j] * dp[cmp-j];
        		cnt %= 1000000007;
        	}
        	dp[i] = cnt;
        }
        
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
        	int L = Integer.parseInt(br.readLine());
        	sb.append(dp[L]).append('\n');
        }
        System.out.println(sb);
	}
}
