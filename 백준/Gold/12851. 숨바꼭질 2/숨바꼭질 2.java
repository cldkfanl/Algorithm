import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        int flag[] = new int[100001];
        int count = 0;
        flag[N] = 1;
        int mintime = 987654321;
        if(N >= K) {
        	System.out.println(N-K);
        	System.out.println(1);
        }
        else {
        	q.add(N);
            while(!q.isEmpty()) {
            	int now = q.poll();
            	if(mintime >= flag[now]) {
                	for(int i=0; i<3; i++) {
                    	int nxt;
                		if(i == 0) {
                			nxt = now + 1;
                		}
                		else if(i == 1) {
                			nxt = now - 1;
                		}
                		else {
                			nxt = now * 2;
                		}
                		if(nxt <= 100000 && nxt >= 0) {
                    		if(nxt == K) {
                    			count++;
                    			mintime = flag[now];
                    		}
                    		if(flag[nxt] == 0 || flag[nxt] == flag[now] + 1) {
                    			q.add(nxt);
                    			flag[nxt] = flag[now] + 1;
                    		}
                		}
                	}
            	}
            }
            System.out.println(mintime);
            System.out.println(count);
        }
    }
}
