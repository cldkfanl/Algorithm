import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static class Loc{
		int x;
		int y;
		int cnt;
		public Loc(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	static int fx[] = {-2, -1, 1, 2};
	static int fy[] = {1, 2, 2, 1};
	static int N,M;
	static boolean arr[][];
	static int output = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        System.out.println(check());
    }
    static int check() {
    	if(N ==1) {
    		return 1;
    	}
    	if(N == 2) {
    		return Math.min(4, (M+1)/2);
    	}
    	if(M<7) {
    		return Math.min(4, M);
    	}
    	return M-2;
    }
}
