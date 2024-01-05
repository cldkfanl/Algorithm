import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int V, E;
	static ArrayList<Integer>[] al;
	static int flag[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            flag = new int[V+1];
            al = new ArrayList[V+1];
            for(int j=0; j<=V; j++) {
            	al[j] = new ArrayList<Integer>();
            }
            for(int j=0; j<E; j++) {
            	st = new StringTokenizer(br.readLine(), " ");
            	int u = Integer.parseInt(st.nextToken());
            	int v = Integer.parseInt(st.nextToken());
            	al[u].add(v);
            	al[v].add(u);
            }
            graph();
        }
        System.out.println(sb);
	}
	static void graph() {
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1; i<=V; i++) {
			if(flag[i] == 0) {
				q.add(i);
				flag[i] = 1;
			}
			
			while(!q.isEmpty()) {
				int now = q.poll();
				
				for(int j=0; j<al[now].size(); j++) {
					if(flag[al[now].get(j)] == 0) {
						q.add(al[now].get(j));
					}
					
					if(flag[al[now].get(j)] == flag[now]) {
						sb.append("NO").append('\n');
						return;
					}
					if(flag[now] == 1 && flag[al[now].get(j)] == 0) {
						flag[al[now].get(j)] = 2;
					}
					else if(flag[now] == 2 && flag[al[now].get(j)] == 0) {
						flag[al[now].get(j)] = 1;
					}
				}
			}
		}
		sb.append("YES").append('\n');
	}
}
