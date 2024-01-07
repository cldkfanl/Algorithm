import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long len[] = new long[N-1];
        long price[] = new long[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N-1; i++) {
        	len[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N-1; i++) {
        	price[i] = Long.parseLong(st.nextToken());
        }
        long output = len[0] * price[0];
        int cnt = 0;
        for(int i=1; i<N-1; i++) {
        	if(price[cnt] * len[i] > price[i] * len[i]) {
        		cnt = i;
        		output += price[i] * len[i];
        	}
        	else {
        		output += price[cnt] * len[i];
        	}
        }
        System.out.println(output);
	}
}
