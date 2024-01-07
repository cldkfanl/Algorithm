import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>(N + 1);
        int output[] = new int[N+1];
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int fir = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());
            tree.get(fir).add(sec);
            tree.get(sec).add(fir);
        }
        q.add(1);
        while(!q.isEmpty()) {
        	int now = q.poll();
        	for(int nxt : tree.get(now)) {
        		if(output[nxt] == 0) {
        			output[nxt] = now;
        			q.add(nxt);
        		}
        	}
        }
        for(int i=2; i<=N; i++) {
        	System.out.println(output[i]);
        }
    }
}
