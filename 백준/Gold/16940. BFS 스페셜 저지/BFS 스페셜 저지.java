import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<HashSet<Integer>> list;
	static int seq[];
	static int visit[];
	static int N;
	static Queue<Integer> q;
	static int index;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        visit = new int[N+1];
        seq = new int[N+1];
        q = new LinkedList<Integer>();
        for(int i=0; i<=N; i++) {
        	list.add(new HashSet<>());
        }
        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            list.get(f).add(s);
            list.get(s).add(f);
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++) {
        	seq[i] = Integer.parseInt(st.nextToken());
        }
        if(seq[1] != 1) {
        	System.out.println("0");
        	return;
        }
        bfs(1);
	}
	static void bfs(int x) {
		q.offer(x);
		visit[x] = 1;
		index = 2;
		while(!q.isEmpty()) {
			int nw = q.poll();
			int count = 0;
			for(int nxt : list.get(nw)) {
				if(visit[nxt] == 0) {
					visit[nxt] = 1;
					count++;
				}
			}
			for(int i= index; i<index+count; i++) {
				if(visit[seq[i]] == 0) {
					System.out.println("0");
					return;
				}
				else {
					q.offer(seq[i]);
				}
			}
			index += count;
		}
		System.out.println("1");
	}
}
