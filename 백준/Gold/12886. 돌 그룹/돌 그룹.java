import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Group{
	int A;
	int B;
	public Group(int A, int B) {
		this.A = A;
		this.B = B;
	}
}
public class Main {
	static int A,B,C;
	static int output = 0;
	static boolean flag[][] = new boolean[1001][1001];
	static int sum;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        sum = A+B+C;
        if(sum % 3 == 0) {
            bfs();
        }
        System.out.println(output);
	}
	static void bfs() {
    	Queue<Group> q = new LinkedList<>();
    	
    	q.offer(new Group(A,B));
    	flag[A][B] = true;
    	flag[B][A] = true;
    	
    	boolean tf = false;
    	while(!q.isEmpty()) {
    		Group g = q.poll();
    		int a = g.A;
    		int b = g.B;
    		int c = sum - a - b;
    		if(a == b && b == c) {
    			tf = true;
    			break;
    		}
    		if(a != b) {
    			int na;
    			int nb;
    			if(a > b) {
    				na = a - b;
    				nb = 2 * b;
    			}
    			else {
    				na = 2 * a;
    				nb = b - a;
    			}
    			if(na <= 1000 && nb <= 1000 && !flag[na][nb]) {
    				flag[na][nb] = true;
    				flag[nb][na] = true;
    				q.offer(new Group(na, nb));
    			}
    		}
    		
    		if(a != c) {
    			int na;
    			int nc;
    			if(a > c) {
    				na = a - c;
    				nc = 2 * c;
    			}
    			else {
    				na = 2 * a;
    				nc = c - a;
    			}
    			if(na <= 1000 && nc <= 1000 && !flag[na][nc]) {
    				flag[na][nc] = true;
    				flag[nc][na] = true;
    				q.offer(new Group(na, nc));
    			}
    		}
    		if(b != c) {
    			int nb;
    			int nc;
    			if(b > c) {
    				nb = b - c;
    				nc = 2 * c;
    			}
    			else {
    				nb = 2 * b;
    				nc = c - b;
    			}
    			if(nc <= 1000 && nb <= 1000 && !flag[nb][nc]) {
    				flag[nc][nb] = true;
    				flag[nb][nc] = true;
    				q.offer(new Group(nb, nc));
    			}
    		}
    		
    	}
    	if(!tf) {
    		output = 0;
    	}
    	else {
    		output = 1;
    	}
	}
}
