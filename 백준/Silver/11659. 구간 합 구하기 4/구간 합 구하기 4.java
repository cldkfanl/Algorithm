import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException{
		StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = Integer.parseInt(st.nextToken());
        int arr[] = new int[count];
        int num = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        long sum2[] = new long[count+1];
        for(int i=1; i<=count; i++) {
            arr[i-1] = Integer.parseInt(st2.nextToken());
            sum2[i] = sum2[i-1] + arr[i-1];
        }

        for(int i=0; i<num; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st3.nextToken());
            int end = Integer.parseInt(st3.nextToken());
            long sum = sum2[end]- sum2[start-1];
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
	}
}
