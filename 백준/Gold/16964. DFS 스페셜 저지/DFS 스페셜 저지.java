import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> list;
	static int seq[];
	static boolean visit[];
	static int N, idx;
	static int index;
	static boolean flag = true;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i = 0 ; i <= N ; ++i) {
        	list.add(new ArrayList<>());
        }
        visit = new boolean[N+1];
        seq = new int[N];
        idx = 1;
        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            list.get(f).add(s);
            list.get(s).add(f);
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
        	seq[i] = Integer.parseInt(st.nextToken());
        }
        if(seq[0] != 1) {
        	System.out.println(0);
        	return;
        }
        dfs(1);
        if(flag) {
        	System.out.println(1);
        }
        else {
        	System.out.println(0);
        }

    }
    static void dfs(int start) {
    	if(visit[start]) {
    		return;
    	}
    	visit[start] = true;
    	HashSet<Integer> set = new HashSet<>();
    	for(int nxt : list.get(start)) {
    		if(visit[nxt]) {
    			continue;
    		}
			set.add(nxt);
    	}
    	if(set.size() == 0) {
    		return;
    	}
    	if(set.contains(seq[idx])) {
    		dfs(seq[idx++]);
    	}
    	else {
    		flag = false;
    	}
    }
}
