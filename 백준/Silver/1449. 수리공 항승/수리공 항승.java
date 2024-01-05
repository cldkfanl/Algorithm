import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        boolean flag[] = new boolean[1001];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
        	flag[Integer.parseInt(st.nextToken())] = true;
        }
        int count = 0;
        for(int i=0; i<=1000; i++) {
        	if(flag[i]) {
        		for(int j=0; j<L; j++) {
        			if(i+j <=1000) {
        				flag[i+j] = false;
        			}
        		}
        		count++;
        	}
        }
        System.out.println(count);
    }
}
