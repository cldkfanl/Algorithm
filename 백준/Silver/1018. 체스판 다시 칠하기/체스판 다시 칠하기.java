import java.util.*;

public class Main{
		
	public static int arr_test[][] = new int[8][8];
	public static int[][] arr;
    public static int count_min = 64;
	
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        arr = new int[a][b];

        for(int i=1; i<=8; i++) {
        	for(int j=1; j<=8; j++) {
        		if((i+j)%2==0) {
        			arr_test[i-1][j-1] = 1;
        		}
        		else {
        			arr_test[i-1][j-1] = 0;
        		}
        	}
        }
        
        for(int i=0; i<a; i++) {
        	String input_row = sc.next();
        	for(int j = 0 ; j<input_row.length(); j++) {
        		if(input_row.substring(j, j+1).equals("B")) {
        			arr[i][j] = 1;
        		}
        		else {
        			arr[i][j] = 0;
        		}
        	}
        }
        
        for(int i=0; i<a-7; i++) {
        	for(int j=0; j<b-7; j++) {
        		cmp_arr(i,j);
        	}
        }
        System.out.println(count_min);
    }
	
	
	
	public static void cmp_arr(int x,int y) {
		int p_count = 0;
		int m_count = 0;
		int c_min = 0;

        for(int k=0; k<8; k++) {
        	for(int l=0; l<8; l++) {
        		if(arr[k+x][l+y] == arr_test[k][l]) {
        			p_count ++;
        		}
        		else {
        			m_count ++;
        		}
        	}
        }


    	if(p_count <= m_count) {
    		c_min = p_count;
    	}
    	else {
    		c_min = m_count;
    	}
    	if(c_min < count_min) {
    		count_min = c_min;
    	}
	}
}