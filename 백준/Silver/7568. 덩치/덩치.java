import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int arr[][] = new int[K][2];
        for(int i=0; i<K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }
        for(int i=0; i<K; i++) {
        	int rank = 1;
        	for(int j=0; j<K; j++) {
        		if(i == j) continue;
        		if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
        			rank++;
        		}
        	}
            System.out.print(rank + " ");
        }
    }
}
