import java.io.*;
import java.util.*;

public class Main {
	static class Loc{
		int num;
		int len;
		public Loc(int num, int len) {
			this.num = num;
			this.len = len;
		}
	}
	static List<Loc> list[];
	static boolean visit[];
	static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        for(int i=1; i<n+1; i++) {
        	list[i] = new ArrayList<Loc>();
        }
        for(int i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int fir = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());
            int thr = Integer.parseInt(st.nextToken());
            list[fir].add(new Loc(sec,thr));
            list[sec].add(new Loc(fir,thr));
        }
        for(int i=1; i<n+1; i++) {
        	visit = new boolean[n+1];
        	visit[i] = true;
        	dfs(i,0);
        }
        System.out.println(ans);
    }
    static void dfs(int num, int size) {
    	for(Loc node : list[num]) {
    		if(!visit[node.num]) {
    			visit[node.num] = true;
    			dfs(node.num , size + node.len);
    		}
    	}
    	ans = Math.max(ans, size);
    }
}
