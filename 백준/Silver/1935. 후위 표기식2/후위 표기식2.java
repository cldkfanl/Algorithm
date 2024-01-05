import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        double arr[] = new double[N];
        for(int i=0; i<N; i++) {
        	arr[i] = Double.parseDouble(br.readLine());
        }
        
        Stack<Double> st = new Stack<>();
        
        double tmp = 0;
        
        for(int i=0; i<input.length(); i++) {
        	if('A' <= input.charAt(i) && 'Z' >= input.charAt(i)) {
        		st.add(arr[input.charAt(i) - 'A']);
        	}
        	else {
        		if(!st.isEmpty()) {
        			double sec = st.pop();
            		double fir = st.pop();
            		
            		switch(input.charAt(i)) {
            		case '+' :
            			tmp = fir + sec;
            			st.add(tmp);
            			break;
            		case '-' :
            			tmp = fir - sec;
            			st.add(tmp);
            			break;
            		case '*' :
            			tmp = fir * sec;
            			st.add(tmp);
            			break;
            		case '/' :
            			tmp = fir / sec;
            			st.add(tmp);
            			break;
            		}
        		}
        	}
        }
        System.out.printf("%.2f", st.pop());
	}
}
