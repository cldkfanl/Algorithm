import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            LinkedList<int[]> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
            	q.offer(new int[] { j, Integer.parseInt(st.nextToken()) });
            }
            int count = 0;

            while(!q.isEmpty()) {
            	int[] front = q.poll();
            	boolean isMax = true;
            	for(int k=0; k<q.size(); k++) {
            		if(front[1] < q.get(k)[1]) {
            			q.offer(front);
            			for(int j = 0; j<k; j++) {
            				q.offer(q.poll());
            			}
            			isMax = false;
            			break;
            		}
            	}
            	if(!isMax) {
            		continue;
            	}
            	count++;
            	if(front[0] == M) {
            		break;
            	}
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}
