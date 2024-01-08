import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char arr[][] = new char[N][M];
        boolean flag[][] = new boolean[N][M];
        
        for(int i=0; i<N; i++) {
        	String input = br.readLine();
        	for(int j=0; j<M; j++) {
        		arr[i][j] = input.charAt(j);
        	}
        }
        ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();
		ArrayList<Integer> s = new ArrayList<Integer>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int size = 0;
				if(arr[i][j] == '*') {
					for(int k=1; ;k++) {
						if(i-k >= 0 && i+k < N && j-k >=0 && j+k < M) {
							if(arr[i-k][j] == '*' && arr[i+k][j] == '*' && arr[i][j-k] == '*' && arr[i][j+k] == '*') {
								size = k;
							}
							else break;
						}
						else break;
					}
				}
				if(size > 0) {
					x.add(i+1);
					y.add(j+1);
					s.add(size);
					flag[i][j] = true;
					for(int k=1; k<=size; k++) {
						flag[i+k][j] = true;
						flag[i-k][j] = true;
						flag[i][k+j] = true;
						flag[i][j-k] = true;
					}
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == '*' && !flag[i][j]) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}
		int count = 0;
		for(int i=0; i<x.size(); i++) {
			for(int j=s.get(i); j>=1; j--) {
				sb.append(x.get(i) + " " + y.get(i) + " " + j).append('\n');
				count++;
			}
		}
		System.out.println(count);
		System.out.println(sb);
	}
}
