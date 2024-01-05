import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static LinkedList<Integer> q;
	public static int q_state;
    public static String output = "";
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        q = new LinkedList<>();
		st = new StringTokenizer(br.readLine(), " ");
        int b = Integer.parseInt(st.nextToken());
        for(int i=1; i<=b; i++) {
        	q.add(i);
        }
        int state = Integer.parseInt(st.nextToken());
        q_state = state-1;
        while(q.size() > 0) {
        	yosep(state);
        }
    	System.out.print("<" + output.substring(0,output.length()-2) + ">");
	}
	public static void yosep(int count) {
		if(q_state >= q.size()) {
			q_state %= q.size();
		}
		else {
			output += q.get(q_state) + ", ";
			q.remove(q_state);
			q_state += count-1;
		}
	}
}