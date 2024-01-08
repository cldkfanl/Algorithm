import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int arr[][] = new int[a][3];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<a; i++) {
        	arr[i][0] = Integer.parseInt(st.nextToken());
        	arr[i][1] = i;
        }
        
        Arrays.sort(arr, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] s1, int[] s2) {
        		return Integer.compare(s1[0], s2[0]);
        	}
        });
        
        arr[0][2] = 0;
        for(int i=1; i<a; i++) {
        	if(arr[i-1][0] < arr[i][0]) {
        		arr[i][2] += arr[i-1][2]+1; 
        	}
        	else {
        		arr[i][2] = arr[i-1][2];
        	}
        }
        
        Arrays.sort(arr, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] s1, int[] s2) {
        		return Integer.compare(s1[1], s2[1]);
        	}
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<a; i++) {
        	sb.append(arr[i][2]).append(" ");
        }
        System.out.print(sb.toString());
	}
	}