import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int arr[] = new int[101];
	static boolean flag[] = new boolean[101];
	static int output = 0;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        bfs(1);
        System.out.println(output);
	}
	static void bfs(int start) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {start, 0});
		flag[start] = true;
		
		while(!q.isEmpty()) {
			int[] cnt = q.poll();
			int n = cnt[0];
			int count = cnt[1];
			if(n == 100) {
				output = count;
				return;
			}
			for(int i=1; i<=6; i++) {
				int nxt = n + i;
				
				if(nxt <= 100 && !flag[nxt]) {
					flag[nxt] = true;
					if(arr[nxt] != 0) {
						q.add(new int[] {arr[nxt], count+1});
					}
					else {
						q.add(new int[] {nxt, count+1});
					}
				}
			}
		}
	}
}
