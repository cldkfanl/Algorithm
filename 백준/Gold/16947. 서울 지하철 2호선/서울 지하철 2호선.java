import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int distance[];
	static boolean flag[], isCycle;
	static Queue<Integer> q = new LinkedList<Integer>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        distance = new int[N+1];
        flag = new boolean[N+1];
        Arrays.fill(distance, -1);
        
        
        ArrayList<Integer> arr[] = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
        	arr[i] = new ArrayList<Integer>();
        }
        
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            arr[f].add(s);
            arr[s].add(f);
        }
        dfs(arr,0,1);
        bfs(arr);
        for(int i=1; i<=N; i++) {
        	sb.append(distance[i]).append(" ");
        }
        System.out.println(sb);
	}
	static void bfs(ArrayList<Integer>[] arr) {
		int cnt = 1;
		while(!q.isEmpty()) {
			int len = q.size();
			for(int j=0; j<len; j++) {
				int tmp = q.poll();
				for(int i : arr[tmp]) {
					if(distance[i] != -1) {
						continue;
					}
					distance[i] = cnt;
					q.add(i);
				}
			}
			cnt++;
		}
	}
	static void dfs(ArrayList<Integer>[] arr, int prev, int curr) {
		flag[curr] = true;
		for(int nxt : arr[curr]) {
			if(flag[nxt] && nxt != prev) {
				isCycle = true;
				distance[nxt] = 0;
				q.add(nxt);
				break;
			}
			else if(!flag[nxt]) {
				dfs(arr, curr, nxt);
				if(isCycle) {
					if(distance[nxt] == 0) {
						isCycle = false;
					}
					else {
						distance[nxt] = 0;
						q.add(nxt);
					}
					return;
				}
			}
		}
	}
}
