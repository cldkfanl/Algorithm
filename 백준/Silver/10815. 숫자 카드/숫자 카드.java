import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        HashSet<Integer> check = new HashSet<>();
        for(int i=0; i<N; i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	check.add(tmp);
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	if(check.contains(tmp)) {
        		sb.append(1).append(" ");
        	}
        	else {
        		sb.append(0).append(" ");
        	}
        }
        System.out.println(sb);
    }
}
