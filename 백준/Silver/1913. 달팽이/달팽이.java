import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int find = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][N];
        int xs = N/2;
        int ys = N/2;
        int start = 1;
        arr[xs][ys] = start;
        for(int i=1; i<=N/2; i++) {
        	int min = N/2 - i;
        	int max = N/2 + i;
        	arr[--xs][ys] = ++start;
        	while(ys < max) {
        		ys++;
        		arr[xs][ys] = ++start;

        	}
        	while(xs < max) {
        		xs++;
        		arr[xs][ys] = ++start;

        	}
        	while(ys > min) {
        		ys--;
        		arr[xs][ys] = ++start;

        	}
        	while(xs > min) {
        		xs--;
        		arr[xs][ys] = ++start;
        	}
        }
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		sb.append(arr[i][j]).append(" ");
        		if(arr[i][j] == find) {
        			sb2.append((i+1) + " " + (j +1));
        		}
        	}
        	sb.append("\n");
        }
        System.out.print(sb);
        System.out.println(sb2);
	}
}
