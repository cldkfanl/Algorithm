import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N,M,V;
	static int arr[][];
	static boolean check[];
	static Queue<Integer> q = new LinkedList<>();
	static StringBuilder sb= new StringBuilder();
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];
        check = new boolean[N+1];
        for(int i=0; i<M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st2.nextToken());
            int second = Integer.parseInt(st2.nextToken());
            arr[first][second] = arr[second][first] = 1;
        }
        dfs(V);
        sb.append('\n');
        check = new boolean[N+1];
        bfs(V);
        System.out.println(sb);
        
	}
	public static void dfs(int V) {
		check[V] = true;
		sb.append(V).append(' ');
		for(int i=0; i<=N; i++) {
			if(arr[V][i] == 1 && !check[i]) {
				dfs(i);
			}
		}
	}
	public static void bfs(int V) {
		q.add(V);
		check[V] = true;
		while(!q.isEmpty()) {
			V = q.poll();
			sb.append(V).append(' ');
			for(int i=0; i<=N; i++) {
				if(arr[V][i] == 1 && !check[i]) {
					q.add(i);
					check[i] = true;
				}
			}
		}
	}
}
