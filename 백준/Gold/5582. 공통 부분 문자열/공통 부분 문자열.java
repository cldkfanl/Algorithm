import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char fir[];
	static char sec[];
	static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        fir = br.readLine().toCharArray();
        sec = br.readLine().toCharArray();
        dp = new int[fir.length+1][sec.length+1];
        int cnt = 0;
        for(int i=1; i<=fir.length; i++) {
        	for(int j=1; j<=sec.length; j++) {
        		if(fir[i-1] == sec[j-1]) {
        			dp[i][j] = dp[i-1][j-1] + 1;
        			if(dp[i][j] > cnt) {
        				cnt = dp[i][j];
        			}
        		}
        	}
        }
        System.out.println(cnt);
    }
}
