import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int output = 0;
        int i = 666;
        int count = 1;

        while (count != a) {
        	i ++;
        	if(String.valueOf(i).contains("666")) {
        		count++;
        	}
        }
        System.out.println(i);
    }
}
