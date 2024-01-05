import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean flag[][] = new boolean[N+1][M+1];
        flag[0][S] = true;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++) {
        	int cnt = Integer.parseInt(st.nextToken());
        	for(int j=0; j<=M; j++) {
        		if(flag[i-1][j]) {
        			if(cnt + j <= M) {
        				flag[i][j + cnt] = true;
        			}
        			if(j - cnt >= 0) {
        				flag[i][j-cnt] = true;
        			}
        		}	
        	}
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<=M; i++) {
        	if(flag[N][i]) {
        		max = Math.max(max, i);
        	}
        }
        if(max != Integer.MIN_VALUE) {
            System.out.println(max);
        }
        else {
        	System.out.println(-1);
        }
	}
}
