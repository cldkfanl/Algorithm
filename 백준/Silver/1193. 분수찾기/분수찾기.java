import java.util.*;

public class Main {
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int count = 2;
        int range = 1;
        int fir = 0;
        int sec = 0;
        while(input > range) {
        	if(input > range) {
        		range += count;
        		count ++;
        	}
        }
        sec = range - input + 1;
        fir = count - sec;        
        if((fir+sec)%2 == 1) {
            System.out.println(fir + "/" + sec);
        }
        else {
        	System.out.println(sec + "/" + fir);
        }
    }
}