import java.io.*;
import java.util.*;
public class Main {
	static class Loc{
		int x;
		int len;
		
		Loc(int x, int len){
			this.x = x;
			this.len = len;
		}
	}
	public static void main(String args[]) throws IOException{
		StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=N; i++) {
        	graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int fir = Integer.parseInt(st.nextToken());
        	int sec = Integer.parseInt(st.nextToken());
        	graph.get(fir).add(sec);
        }
        int check[] = new int[N+1];
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(X,0));
        check[X] = 1;
        List<Integer> output = new ArrayList<>();
        while(!q.isEmpty()) {
        	Loc now = q.poll();
        	if(now.len == K) {
        		output.add(now.x);
        	}
        	else {
            	for(int nxt : graph.get(now.x)) {
            		if(check[nxt] == 0) {
            			q.add(new Loc(nxt, now.len + 1));
            			check[nxt] = 1;
            		}
            	}
        	}
        }
        if(output.isEmpty()) {
        	System.out.println(-1);
        }
        else {
        	Collections.sort(output);
        	for(int r : output) {
        		sb.append(r).append('\n');
        	}
        	System.out.println(sb);
        }
	}
}
