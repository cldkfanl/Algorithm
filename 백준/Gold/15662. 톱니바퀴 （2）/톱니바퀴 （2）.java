import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static int T;
	static int output = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        arr = new int[T+1][8];
        for(int i=1; i <= T; i++) {
            String input = br.readLine();
        	for(int j=0; j<8; j++) {
                arr[i][j] = input.charAt(j) - '0';
        	}
        }
        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	int number = Integer.parseInt(st.nextToken());
        	int swing = Integer.parseInt(st.nextToken());
        	swing_2(number, swing);
        }
        for(int i=1; i<=T; i++) {
        	if(arr[i][0] == 1) {
        		output++;
        	}
        }
        System.out.println(output);
	}
	public static void swing_2(int number, int swing) {
		boolean flag = false;
		boolean flag2 =false;
		if(swing == 1) {
			int temp = arr[number][7];
			for(int i = 7; i>0; i--) {
				arr[number][i] = arr[number][i-1];
			}
			arr[number][0] = temp;
		}
		else{
			int temp = arr[number][0];
			for(int i = 0; i<7; i++) {
				arr[number][i] = arr[number][i+1];
			}
			arr[number][7] = temp;
		}
		for(int i=number-1; i>0; i--) {
			if(flag) {
				continue;
			}
			else {
				if(swing == -1) {
					if((number-i)%2 == 1) {
						if(arr[i+1][5]!= arr[i][2]) {
							swingright(i);
						}
						else {
							flag = true;
							continue;
						}
					}
					else {
						if(arr[i+1][7]!= arr[i][2]) {
							swingleft(i);
						}
						else {
							flag = true;
							continue;
						}
					}
				}
				else if(swing == 1) {
					if((number-i)%2 == 1) {
						if(arr[i+1][7]!= arr[i][2]) {
							swingleft(i);
						}
						else {
							flag = true;
							continue;
						}
					}
					else {
						if(arr[i+1][5]!= arr[i][2]) {
							swingright(i);
						}
						else {
							flag = true;
							continue;
						}
					}
				}
			}
		}
		for(int i=number+1; i<=T; i++) {
			if(flag2) {
				continue;
			}
			else {
				if(swing == -1) {
					if((i-number)%2 == 1) {
						if(arr[i-1][1]!= arr[i][6]) {
							swingright(i);
						}
						else {
							flag2 = true;
							continue;
						}
					}
					else {
						if(arr[i-1][3]!= arr[i][6]) {
							swingleft(i);
						}
						else {
							flag2 = true;
							continue;
						}
					}
				}
				else if(swing == 1) {
					if((i-number)%2 == 1) {
						if(arr[i-1][3]!= arr[i][6]) {
							swingleft(i);
						}
						else {
							flag2 = true;
							continue;
						}
					}
					else {
						if(arr[i-1][1]!= arr[i][6]) {
							swingright(i);
						}
						else {
							flag2 = true;
							continue;
						}
					}
				}
			}
		}     
	}
	public static void swingleft(int num) {
		int temp = arr[num][0];
		for(int i = 0; i<7; i++) {
			arr[num][i] = arr[num][i+1];
		}
		arr[num][7] = temp;
	}
	public static void swingright(int num) {
		int temp = arr[num][7];
		for(int i = 7; i>0; i--) {
			arr[num][i] = arr[num][i-1];
		}
		arr[num][0] = temp;
	}
}
