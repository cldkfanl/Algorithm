import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        boolean arr[] = new boolean[N+1];
        Deque<Integer> deq = new LinkedList<>();
        for(int i = 1; i<= N; i++) {
        	deq.add(i);
        	arr[i] = true;
        }
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int output = 0;
        for(int i=0; i<M; i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	if(tmp == deq.getFirst()) {
        		deq.pollFirst();
        		arr[tmp] = false;
        	}
        	else {
        		int fcnt = 0;
        		int lcnt = 0;
        		if(tmp > deq.getFirst()) {
        			for(int j=deq.getFirst(); j<= tmp; j++) {
        				if(arr[j]) {
        					fcnt ++;
        				}
        			}
        			for(int j=deq.getFirst(); j>=1; j--) {
        				if(arr[j]) {
        					lcnt ++;
        				}
        			}
        			for(int j=N; j>= tmp; j--) {
        				if(arr[j]) {
        					lcnt++;
        				}
        			}
        		}
        		else if(tmp < deq.getFirst()) {
        			for(int j=deq.getFirst(); j<= N; j++) {
        				if(arr[j]) {
        					fcnt ++;
        				}
        			}
        			for(int j=1; j<=tmp; j++) {
        				if(arr[j]) {
        					fcnt++;
        				}
        			}
        			for(int j=deq.getFirst(); j>=tmp; j--) {
        				if(arr[j]) {
        					lcnt ++;
        				}
        			}
        		}
        		while(deq.getFirst() != tmp) {
        			if(fcnt > lcnt) {
        				int tmp2 = deq.pollLast();
        				deq.addFirst(tmp2);
        				output++;
        			}
        			else {
        				int tmp2 = deq.pollFirst();
        				deq.addLast(tmp2);
        				output++;
        			}
        		}
        		int out = deq.pollFirst();
        		arr[out] = false;
        	}
        }
        System.out.println(output);
    }
}
