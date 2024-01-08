import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,L,R,X;
	static int arr[];
	static int output = 0;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,Integer.MAX_VALUE, Integer.MIN_VALUE, 0 , 0);
        
        System.out.println(output);
	}
	static void dfs(int depth , int min, int max, long sum , int count) {
		if(depth == N) {
			if(count >= 2 && sum >= L && sum <= R && (max-min) >= X) {
				output++;
			}
			return;
		}
		
		int tmp = arr[depth];
		dfs(depth+1 , Math.min(tmp, min) , Math.max(tmp, max) , sum + tmp , count+1);
		
		dfs(depth+1 , min , max , sum , count);
	}
}
