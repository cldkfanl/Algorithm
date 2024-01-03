import java.util.*;
public class Main{
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int min = 5000;
        
        for(int i=0; i<=1000; i++) {
        	for(int j=0; j<=1700; j++) {
        		if(i*5 + j*3 == a) {
        			if(min > i+j) {
        				min = i+j;
        			}
        		}
        	}
        }
        if(min == 5000) {
        	System.out.println(-1);
        }
        else {
            System.out.println(min);
        }
    }
}