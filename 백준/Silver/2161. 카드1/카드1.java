import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++) {
        	q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N-1; i++) {
        	int fir = q.poll();
        	int sec = q.poll();
        	sb.append(fir).append(" ");
        	q.add(sec);
        }
        sb.append(q.poll());
        System.out.println(sb);
	}
}
