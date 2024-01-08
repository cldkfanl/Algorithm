import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long X;
	static long total[], pat[];
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Long.parseLong(st.nextToken());
        total = new long[N+1];
        pat = new long[N+1];
        total[0] = 1;
        pat[0] = 1;
        for(int i=1; i<=N; i++) {
        	total[i] = total[i-1]*2 + 3;
        	pat[i] = pat[i-1]*2 + 1;
        }
        long output = dp(N, X);
        System.out.println(output);
	}
	static long dp(int n, long x) {
		if(n == 0) {
			if(x == 0) {
				return 0;
			}
			else if(x == 1) {
				return 1;
			}
		}
		if(x == 1) {
			return 0;
		}
		else if(x <= 1 + total[n-1]) {
			return dp(n-1,x-1);
		}
		else if(x <= 1 + total[n-1] + 1) {
			return pat[n-1] + 1;
		}
		else if(x <=1 + total[n-1] + 1 + total[n-1]) {
			return pat[n-1] + 1 + dp(n-1, x - (1 + total[n-1] + 1));
		}
		
		else {
			return pat[n-1] + 1 + pat[n-1];
		}
	}
}
