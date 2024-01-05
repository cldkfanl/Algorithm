import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long min = 0;
        while(true) {
        	min = Math.min(e, Math.min(s, m));
        	if(e == s && e == m) {
        		min = e;
        		break;
        	}
        	else if(min == e) {
        		e += 15;
        	}
        	else if(min == s) {
        		s += 28;
        	}
        	else if(min == m) {
        		m += 19;
        	}

        }
        System.out.println(min);
	}
}