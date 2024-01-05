import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long number = Long.parseLong(br.readLine());
        long output = 0;
        int digit = 1;
        int count = 0;
        int len = String.valueOf(number).length();
        if(len >=2) {
        for(int i=1; i<len; i++) {
        	output += digit*(Math.pow(10, digit)-Math.pow(10, digit-1));
        	digit ++;
        }
        for(int i=(int) Math.pow(10, len-1); i<=number; i++) {
        	output += digit;
        }
        }
        else {
        	for(int i=1; i<=number; i++) {
        		output += 1;
        	}
        }

        System.out.println(output);
	}
}