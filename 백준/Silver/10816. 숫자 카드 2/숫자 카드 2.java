import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for(int i=0; i<N; i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	if(hash.get(tmp) == null) {
        		hash.put(tmp, 1);
        	}
        	else {
        		hash.put(tmp, hash.get(tmp) + 1);
        	}
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	if(hash.get(tmp) == null) {
        		sb.append(0).append(" ");
        	}
        	else {
            	sb.append(hash.get(tmp)).append(" ");
        	}
        }
        System.out.println(sb);
    }
}
