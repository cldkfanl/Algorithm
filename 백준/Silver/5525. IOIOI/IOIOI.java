import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char arr[] = br.readLine().toCharArray();
        int output = 0;
        int check = 0;
        for(int i=1; i<M-1; i++) {
        	if(arr[i] == 'O' && arr[i-1] == 'I' && arr[i+1] == 'I') {
        		check ++;
            	if(check == N) {
            		output ++;
            		check--;
            	}
            	i++;
        	}
        	else {
        		check = 0;
        	}
        }
        System.out.println(output);
    }
}