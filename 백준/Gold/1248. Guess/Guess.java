import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	static Character arr[][];
	static int arr_2[];
	static int count;
	static boolean flag[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(br.readLine());
        arr = new Character[count][count];
        arr_2 = new int[count];
        String input = br.readLine();
        int inputIndex = 0;
        for(int i=0; i<count; i++) {
        	for(int j=i; j<count; j++) {
                arr[i][j] = input.charAt(inputIndex++);
        	}
        }
        choosenum(0);
        System.out.println(sb);
	}
	public static void choosenum(int depth) {
		if(depth == count) {
			for(int i=0; i<count; i++) {
				sb.append(arr_2[i]).append(' ');
			}
			System.out.println(sb);
			System.exit(0);
		}
		for(int i=-10; i<=10; i++) {
			arr_2[depth] = i;
			if(check(depth)) {
				choosenum(depth+1);
			}
		}
	}
	public static boolean check(int depth) {
		int count2 = 0;
		for(int i=0; i<=depth; i++) {
			int comp = 0;
			for(int j=i; j<=depth; j++) {
				comp += arr_2[j];
				if(arr[i][j].equals('+')){
					if(comp <= 0) {
						count2 ++;
					}
				}
				else if(arr[i][j].equals('-')){
					if(comp >= 0) {
						count2 ++;
					}
				}
				else if(arr[i][j].equals('0')){
					if(comp != 0) {
						count2 ++;
					}
				}
			}
		}
		if(count2 ==0) {
			return true;
		}
		else {
			return false;
		}
	}
}
