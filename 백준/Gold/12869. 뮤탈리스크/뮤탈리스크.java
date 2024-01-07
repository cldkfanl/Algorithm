import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int dp[][][];
	static int scv[] = new int[3];
	static int zerocount = 0;
	static int output = Integer.MAX_VALUE;
	static int fx[][] = {{-9,-3,-1},{-9,-1,-3},{-3,-9,-1},{-3,-1,-9},{-1,-9,-3},{-1,-3,-9}};
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[61][61][61];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i=0; i<N; i++) {
    		scv[i] = Integer.parseInt(st.nextToken());
    	}
    	dfs(scv,0);
    	System.out.println(output);
	}
	static void dfs(int[] scv, int cnt) {
		int s1 = scv[0];
		int s2 = scv[1];
		int s3 = scv[2];
		
		if(output <= cnt) {
			return;
		}
		if(dp[s1][s2][s3] != 0 && dp[s1][s2][s3] <= cnt) {
			return;
		}
		dp[s1][s2][s3] = cnt;
		if(s1 == 0 && s2 == 0 && s3 == 0) {
			output = Math.min(output, cnt);
			return;
		}
		for(int i=0; i<6; i++) {
			dfs(new int[] {Math.max(s1 + fx[i][0] , 0), Math.max(s2 + fx[i][1], 0) , Math.max(s3 + fx[i][2], 0)} ,cnt+1);
		}
	}
}
