import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int arr[][];
	static int minval = Integer.MAX_VALUE;
	static int output = 0;
	static class Loc {
		int num;
		int cnt;
    	public Loc(int num, int cnt) {
    		this.num = num;
    		this.cnt = cnt;
    	}
	}
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int A = Integer.parseInt(st.nextToken());
        	int B = Integer.parseInt(st.nextToken());
        	arr[A][B] = 1;
        	arr[B][A] = 1;
        }
        for(int i=1; i<=N; i++) {
            bfs(i);
        }
        System.out.println(output);
	}
	static void bfs(int input) {
		int cnt = 0;
		boolean[] visited = new boolean[N+1];
		visited[input] = true;
		Queue<Loc> q = new LinkedList<>();
		q.add(new Loc(input,0));
		
		while(!q.isEmpty()) {
			Loc now = q.poll();
			cnt += now.cnt;
			
			for(int i=1; i<=N; i++) {
				int num = arr[now.num][i];
				if(arr[now.num][i] == 1 && !visited[i]) {
					q.add(new Loc(i,now.cnt+1));
					visited[i] = true;
				}
			}
		}
		if(minval > cnt) {
			minval = cnt;
			output = input;	
		}
	}
}