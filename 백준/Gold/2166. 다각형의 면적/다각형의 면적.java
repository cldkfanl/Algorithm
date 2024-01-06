import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long x[] = new long[N+1];
        long y[] = new long[N+1];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        x[N] = x[0];
        y[N] = y[0];
        long sum = 0;
        for(int i=0; i<N; i++) {
        	sum += x[i] * y[i+1];
        	sum -= x[i+1] * y[i];
        }
        String area = String.format("%.1f", Math.abs(sum)/2.0);
        System.out.println(area);
    }
}
