import java.io.*;
import java.util.*;

public class Main {
    static long A,B;
    static int cnt;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        System.out.println(check());
    }
    	static int check() {
		Queue<Long> q = new LinkedList<>();
		q.add(A);
		
		while(!q.isEmpty()) {
		    int size = q.size();
		    for(int i=0; i<size; i++){
		        long tmp = q.poll();
		        if(tmp == B){
		            return cnt + 1;
		        }
		        if(tmp*2 <= B) q.add(tmp*2);
		        if(tmp*10+1 <= B) q.add(tmp*10 + 1);
		    }
		    cnt ++;
		}
		return -1;
	}
}