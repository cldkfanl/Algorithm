import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int arr[];
	static boolean flag[];
	static String N;
	static int output = -1;
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        arr = new int[10];
        int sum = 0;
        for(int i=0; i<N.length(); i++) {
        	int tmp = Integer.parseInt(N.substring(i,i+1));
        	arr[tmp]++;
        	sum += tmp;
        }
        if (sum % 3 != 0 || arr[0] == 0) {
            System.out.println("-1");
            return;
        }

        StringBuilder result = new StringBuilder();

        // 9부터 0까지 차례대로 출력
        for (int i = 9; i >= 0; i--) {
            while (arr[i] > 0) {
                result.append(i);
                arr[i]--;
            }
        }

        System.out.println(result.toString());
	}
}
