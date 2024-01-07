import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class cls{
		int start;
		int end;
		
		cls(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        cls lec[] = new cls[N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");	
            int sta = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lec[i] = new cls(sta, end);
        }
        Arrays.sort(lec, (l1, l2) -> l1.start == l2.start ? l1.end - l2.end : l1.start - l2.start);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lec[0].end);
        
        for(int i=1; i<N; i++) {
        	if(pq.peek() <= lec[i].start) {
        		pq.poll();
        	}
        	pq.offer(lec[i].end);
        }
        System.out.println(pq.size());
    }
    
}
