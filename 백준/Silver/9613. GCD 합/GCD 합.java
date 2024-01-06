import java.util.*;

public class Main {
    public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
        for(int i = 0; i< a; i++) {
        	int b = sc.nextInt();
        	int arr[] = new int[b];
        	for(int j= 0; j< b; j++) {
        		arr[j] = sc.nextInt();
        	}
        	long output = 0;
        	for(int i1=0; i1<b-1; i1 ++) {
        		for(int j1 = i1+1; j1 <b; j1++) {
        			for(int k = Math.min(arr[i1], arr[j1]); k>=1; k--) {
        				if(arr[i1] % k == 0 && arr[j1] % k ==0) {
        					output += k;
        					break;
        				}
        			}
        		}
        	}
        	System.out.println(output);
        }
    }
}