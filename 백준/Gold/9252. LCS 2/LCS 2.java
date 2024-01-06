import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char fir[];
	static char sec[];
	static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        fir = br.readLine().toCharArray();
        sec = br.readLine().toCharArray();
        dp = new Integer[fir.length][sec.length];
        int count = lcs(fir.length-1, sec.length-1);
        if(count == 0) {
        	System.out.println(0);
        }
        else {
        	System.out.println(count);
            String lcsString = findLCSString(fir.length - 1, sec.length - 1);
            System.out.println(lcsString);
        }
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
    static String findLCSString(int x, int y) {
        if (x == -1 || y == -1) {
            return "";
        }

        if (fir[x] == sec[y]) {
            return findLCSString(x - 1, y - 1) + fir[x];
        }

        if (x > 0 && (y == 0 || dp[x - 1][y] > dp[x][y - 1])) {
            return findLCSString(x - 1, y);
        } else {
            return findLCSString(x, y - 1);
        }
    }
}
