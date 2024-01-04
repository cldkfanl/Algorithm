import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException{	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	int I = Integer.parseInt(st.nextToken());
    	int cnt = 0;
    	while(K != I) {
    		K = K/2 + K%2;
    		I = I/2 + I%2;
    		cnt++;
    	}
    	System.out.println(cnt);
	}
}
