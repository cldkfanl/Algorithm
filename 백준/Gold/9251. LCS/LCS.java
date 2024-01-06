import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char fir[];
	static char sec[];
	static Integer[][] dp;
	static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        fir = br.readLine().toCharArray();
        sec = br.readLine().toCharArray();
        dp = new Integer[fir.length][sec.length];
        System.out.println(lcs(fir.length-1, sec.length-1));
    }
    static int lcs(int x, int y) {
    	if(x == -1 || y == -1) {
    		return 0;
    	}
    	if(dp[x][y] == null) {
    		dp[x][y] = 0;
    		
    		if(fir[x] == sec[y]) {
    			dp[x][y] = lcs(x-1, y-1) + 1;
    		}
    		
    		else {
    			dp[x][y] = Math.max(lcs(x-1,y), lcs(x,y-1));
    		}
    	}
    	return dp[x][y];
    }
}
