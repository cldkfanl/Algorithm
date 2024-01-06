import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	static int scale;
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        scale = Integer.parseInt(st.nextToken());
        String number = st.nextToken();
        int len = number.length();
        String arr[][] = new String[2*scale + 3][(scale+2)*len];
        int rep = 2*scale+4;
        while(rep-- > 0) {
        	if(rep == 2*scale+3) {
            	printnum(1,number);
        	}
        	else if(rep > scale +2) {
        		printnum(2,number);
        	}
        	else if(rep == scale+2) {
        		printnum(3,number);
        	}
        	else if(rep > 1) {
        		printnum(4,number);
        	}
        	else if(rep == 1) {
        		printnum(5,number);
        	}
        	sb.append('\n');
        }
        System.out.println(sb);
	}
	public static void printnum(int count , String number) {
		int len = number.length();
		for(int i =0; i<len; i++) {
			onetwo(count, number.substring(i,i+1));
		}
	}
	public static void onetwo(int count, String number){
		int num2 = Integer.parseInt(number);
		switch(count) {
		case 1 : 
			sb.append(' ');
			int scale2 = scale;
			while(scale2-- >0) {
				switch(num2) {
				case 1 : sb.append(' ');break;
				case 2 : sb.append('-');break;
				case 3 : sb.append('-');break;
				case 4 : sb.append(' ');break;
				case 5 : sb.append('-');break;
				case 6 : sb.append('-');break;
				case 7 : sb.append('-');break;
				case 8 : sb.append('-');break;
				case 9 : sb.append('-');break;
				case 0 : sb.append('-');break;
				}
			}
			sb.append(' ');
			break;
		case 2 :
			scale2 = scale;
			switch(num2) {
			case 1 : sb.append(' ');break;
			case 2 : sb.append(' ');break;
			case 3 : sb.append(' ');break;
			case 4 : sb.append('|');break;
			case 5 : sb.append('|');break;
			case 6 : sb.append('|');break;
			case 7 : sb.append(' ');break;
			case 8 : sb.append('|');break;
			case 9 : sb.append('|');break;
			case 0 : sb.append('|');break;
			}
			while(scale2 -- >0) {
				switch(num2) {
				case 1 : sb.append(' ');break;
				case 2 : sb.append(' ');break;
				case 3 : sb.append(' ');break;
				case 4 : sb.append(' ');break;
				case 5 : sb.append(' ');break;
				case 6 : sb.append(' ');break;
				case 7 : sb.append(' ');break;
				case 8 : sb.append(' ');break;
				case 9 : sb.append(' ');break;
				case 0 : sb.append(' ');break;
				}
			}
			switch(num2) {
			case 1 : sb.append('|');break;
			case 2 : sb.append('|');break;
			case 3 : sb.append('|');break;
			case 4 : sb.append('|');break;
			case 5 : sb.append(' ');break;
			case 6 : sb.append(' ');break;
			case 7 : sb.append('|');break;
			case 8 : sb.append('|');break;
			case 9 : sb.append('|');break;
			case 0 : sb.append('|');break;
			}
			break;
		case 3 :
			sb.append(' ');
			scale2 = scale;
			while(scale2 -- >0) {
				switch(num2) {
				case 1 : sb.append(' ');break;
				case 2 : sb.append('-');break;
				case 3 : sb.append('-');break;
				case 4 : sb.append('-');break;
				case 5 : sb.append('-');break;
				case 6 : sb.append('-');break;
				case 7 : sb.append(' ');break;
				case 8 : sb.append('-');break;
				case 9 : sb.append('-');break;
				case 0 : sb.append(' ');break;
				}
			}
			sb.append(' ');
			break;
		case 4 :
			scale2 = scale;
			switch(num2) {
			case 1 : sb.append(' ');break;
			case 2 : sb.append('|');break;
			case 3 : sb.append(' ');break;
			case 4 : sb.append(' ');break;
			case 5 : sb.append(' ');break;
			case 6 : sb.append('|');break;
			case 7 : sb.append(' ');break;
			case 8 : sb.append('|');break;
			case 9 : sb.append(' ');break;
			case 0 : sb.append('|');break;
			}
			while(scale2 -- >0) {
				switch(num2) {
				case 1 : sb.append(' ');break;
				case 2 : sb.append(' ');break;
				case 3 : sb.append(' ');break;
				case 4 : sb.append(' ');break;
				case 5 : sb.append(' ');break;
				case 6 : sb.append(' ');break;
				case 7 : sb.append(' ');break;
				case 8 : sb.append(' ');break;
				case 9 : sb.append(' ');break;
				case 0 : sb.append(' ');break;
				}
			}
			switch(num2) {
			case 1 : sb.append('|');break;
			case 2 : sb.append(' ');break;
			case 3 : sb.append('|');break;
			case 4 : sb.append('|');break;
			case 5 : sb.append('|');break;
			case 6 : sb.append('|');break;
			case 7 : sb.append('|');break;
			case 8 : sb.append('|');break;
			case 9 : sb.append('|');break;
			case 0 : sb.append('|');break;
			}
			break;
		case 5 :
			sb.append(' ');
			scale2 = scale;
			while(scale2 -- >0) {
				switch(num2) {
				case 1 : sb.append(' ');break;
				case 2 : sb.append('-');break;
				case 3 : sb.append('-');break;
				case 4 : sb.append(' ');break;
				case 5 : sb.append('-');break;
				case 6 : sb.append('-');break;
				case 7 : sb.append(' ');break;
				case 8 : sb.append('-');break;
				case 9 : sb.append('-');break;
				case 0 : sb.append('-');break;
				}
			}
			sb.append(' ');
			break;
		}
		sb.append(' ');
	}
}
