import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        HashSet<Integer> hash = new HashSet<>();
        for(int i=0; i<A; i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	hash.add(tmp);
        }
        st = new StringTokenizer(br.readLine(), " ");
        int cnt = 0;
        for(int i=0; i<B; i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	if(hash.contains(tmp)) {
        		cnt++;
        	}
        }
        System.out.println(A + B -  (2 * cnt));
    }
}
