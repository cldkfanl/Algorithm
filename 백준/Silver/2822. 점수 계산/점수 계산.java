import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[][] = new int[8][2];
        for(int i=0; i<8; i++) {
            arr[i][0] = Integer.parseInt(br.readLine());
            arr[i][1] = i+1;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int sum = 0;
        int arr2[] = new int[5];
        StringBuilder sb = new StringBuilder();
        for(int i=7; i>=3; i--) {
        	sum += arr[i][0];
        	arr2[i-3] = arr[i][1];
        }
        Arrays.sort(arr2);
        System.out.println(sum);
        for(int i=0; i<5; i++) {
        	System.out.print(arr2[i] + " ");
        }
	}
}
