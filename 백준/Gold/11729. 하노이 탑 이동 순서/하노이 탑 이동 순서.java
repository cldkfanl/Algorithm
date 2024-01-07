import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        hanoi(N, 1,2,3);
        
        System.out.println((int)Math.pow(2, N) -1);
        System.out.println(sb);
	}
	
	public static void hanoi(int cnt, int start, int mid, int end) {
		if(cnt == 1) {
			sb.append(start + " " + end).append("\n");
			return;
		}
		hanoi(cnt-1, start, end, mid);
		sb.append(start + " " + end).append("\n");
		hanoi(cnt-1, mid, start, end);
	}
}
