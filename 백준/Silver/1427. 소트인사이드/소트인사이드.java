import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        
        String a = br.readLine();
        int arr[] = new int[a.length()];
        String output = "";
        
        for(int i = 0; i<a.length(); i++) {
        	arr[i] = Integer.parseInt(a.substring(i,i+1));
        }
        Arrays.sort(arr);
        
        
        for(int i = a.length()-1; i>=0; i--) {
        	output += arr[i];
        }
        System.out.println(output);
    }
}
