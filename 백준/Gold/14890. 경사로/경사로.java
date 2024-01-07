import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static int output = 0;
	static int N;
	static int L;
	static boolean flag[][];
	static boolean flag2[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        flag = new boolean[N][N];
        flag2 = new boolean[N][N];
        for(int i=0; i<N; i++) {
        	StringTokenizer st2 = new StringTokenizer(br.readLine());
        	for(int j = 0; j<N; j++) {
        		arr[i][j] = Integer.parseInt(st2.nextToken());
        	}
        }
        for(int i=0; i<N; i++) {
        	checkrow(i);
        	checkcol(i);
        }
        System.out.println(output);
	}
	public static void checkrow(int row) {
		int count = 0;
		int count2 = 0;
		for(int i = 0; i<N-1; i++) {
			int check = 0;
			int check2 = 0;
			int minus = arr[row][i]-arr[row][i+1];
			if(minus == -1) {
				for(int j = 0; j<L; j++) {
					if(i-j >=0) {
						if(arr[row][i-j] == arr[row][i] && !flag[row][i-j]) {
							flag[row][i-j] = true;
						}
						else {
							check++;
						}
					}
					else {
						check++;
					}
				}
				if(check != 0) {
					count++;
				}
			}
			else if(minus <-1) {
				count++;
			}
			else if(minus == 1) {
				for(int j = 0; j<L; j++) {
					if(i+1+j <=N-1) {
						if(arr[row][i+1] == arr[row][i+1+j] && !flag[row][i+1+j]) {
							flag[row][i+1+j] = true;
						}
						else {
							check2++;
							}
					}
					else {
						check2++;
					}
				}
				if(check2 != 0) {
					count2++;
				}
			}
			else if(minus >1) {
				count2++;
			}
			else {
				continue;
			}
		}
		if(count == 0 && count2 == 0) {
			output++;
		}
	}
	public static void checkcol(int col) {
		int count = 0;
		int count2 = 0;
		for(int i = 0; i<N-1; i++) {
			int check = 0;
			int check2 = 0;
			int minus = arr[i][col]-arr[i+1][col];
			if(minus == -1) {
				for(int j = 0; j<L; j++) {
					if(i-j >=0) {
						if(arr[i-j][col] == arr[i][col] && !flag2[i-j][col]) {
							flag2[i-j][col] = true;
						}
						else {
							check++;
						}
					}
					else {
						check++;
					}
				}
				if(check != 0) {
					count++;
				}
			}
			else if(minus == 1) {
				for(int j = 0; j<L; j++) {
					if(i+1+j <=N-1) {
						if(arr[i+1][col] == arr[i+1+j][col] && !flag2[i+1+j][col]) {
							flag2[i+1+j][col] = true;
						}
						else {
							check2++;
						}
					}
					else {
						check2++;
					}
				}
				if(check2 != 0) {
					count2++;
				}
			}
			else if(minus >1) {
				count2++;
			}
			else if(minus < -1) {
				count2++;
			}
			else {
				continue;
			}
		}
		if(count == 0 && count2 == 0) {
			output++;
		}
	}
}
