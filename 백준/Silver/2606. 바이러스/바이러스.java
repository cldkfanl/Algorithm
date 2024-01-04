import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static boolean flag[][];
	static int N,M;
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        flag = new boolean[N+1][N+1];
        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        bfs();
        System.out.println(set.size()-1);
    }
    static void bfs() {
    	Queue<Integer> q = new LinkedList<>();
    	q.add(1);
    	set.add(1);
    	while(!q.isEmpty()) {
    		int now = q.poll();
    		for(int i=1; i<= N; i++) {
    			if(arr[now][i] == 1 && !flag[now][i]) {
    				q.add(i);
    				set.add(i);
    				flag[now][i] = true;
    			}
    		}
    	}
    }
}
