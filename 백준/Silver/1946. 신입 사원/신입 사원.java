import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
        	int N = Integer.parseInt(br.readLine());
        	int arr[][] = new int[N][2];
        	for(int j=0; j<N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int fir = Integer.parseInt(st.nextToken());
                int sec = Integer.parseInt(st.nextToken());
                arr[j][0] = fir;
                arr[j][1] = sec;
        	}
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[0], o2[0]);
                }
            });
            int count = 1;
            int max = arr[0][1];
            for(int j=1; j<arr.length; j++) {
            	if(arr[j][1] < max) {
            		count++;
            		max = arr[j][1];
            	}
            }
            System.out.println(count);
        }
    } 
}
