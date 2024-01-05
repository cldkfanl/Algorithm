import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static StringBuilder sb = new StringBuilder();
	static int arr[];
	static int ans = 0;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr= new int[N];
    	st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0);
        if(M == 0) {
            System.out.println(ans-1);
        }
        else {
            System.out.println(ans);
        }
	}
	static void dfs(int depth, int sum) {
		if(depth == N) {
			if(sum == M) {
				ans++;
			}
			return;
		}
		dfs(depth+1, sum);
		dfs(depth+1, sum + arr[depth]);
	}
}
