import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int x1 = Integer.parseInt(st.nextToken());
        	int y1 = Integer.parseInt(st.nextToken());
        	int x2 = Integer.parseInt(st.nextToken());
        	int y2 = Integer.parseInt(st.nextToken());
        	int n = Integer.parseInt(br.readLine());
        	int output = 0;
        	for(int j=0; j<n; j++) {
        		st = new StringTokenizer(br.readLine());
        		int c1 = Integer.parseInt(st.nextToken());
        		int c2 = Integer.parseInt(st.nextToken());
        		int r = Integer.parseInt(st.nextToken());
        		
        		boolean checkstart = check(x1, y1, c1, c2, r);
        		boolean checkend = check(x2, y2, c1, c2, r);
        		
        		if(!(checkstart && checkend) && (checkstart || checkend)) {
        			output ++;
        		}
        	}
        	sb.append(output).append('\n');
        }
        System.out.println(sb);
	}
	static boolean check(int x, int y, int x2, int y2, int r) {
		return Math.sqrt(Math.pow(x- x2, 2) + Math.pow(y - y2, 2)) < r; 
	}
}
