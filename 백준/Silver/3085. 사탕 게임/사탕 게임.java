import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a =Integer.parseInt(br.readLine());
        char arr[][] = new char[a][a];
        for(int i=0; i<a; i++) {
        	String b = br.readLine();
        	for(int j=0; j<a; j++) {
        		arr[i][j] = b.charAt(j);
        	}
        }
        int max = 1;
        for(int i=0; i<a; i++) {
        	for(int j=0; j<a-1; j++) {
        		if(arr[i][j] != arr[i][j+1]) {
        			char temp = arr[i][j];
        			arr[i][j] = arr[i][j+1];
        			arr[i][j+1] = temp;
        			for(int i1=0; i1<a; i1++) {
        				int count = 1;
        				for(int j1=0; j1<a-1; j1++) {
        					if(arr[i1][j1] == arr[i1][j1+1]) {
        						count ++;
        						max = Math.max(max, count);
        					}
        					else {
        						count = 1;
        					}
        				}
        			}
        			for(int i1=0; i1<a; i1++) {
        				int count = 1;
        				for(int j1=0; j1<a-1; j1++) {
        					if(arr[j1][i1] == arr[j1+1][i1]) {
        						count ++;
        						max = Math.max(max, count);
        					}
        					else {
        						count = 1;
        					}
        				}
        			}
                    temp = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = temp;
        		}
        	}
        }
        for(int i=0; i<a; i++) {
        	for(int j=0; j<a-1; j++) {
        		if(arr[j][i] != arr[j+1][i]) {
        			char temp = arr[j][i];
        			arr[j][i] = arr[j+1][i];
        			arr[j+1][i] = temp;
        			for(int i1=0; i1<a; i1++) {
        				int count = 1;
        				for(int j1=0; j1<a-1; j1++) {
        					if(arr[i1][j1] == arr[i1][j1+1]) {
        						count ++;
        						max = Math.max(max, count);
        					}
        					else {
        						count = 1;
        					}
        				}
        			}
        			for(int i1=0; i1<a; i1++) {
        				int count = 1;
        				for(int j1=0; j1<a-1; j1++) {
        					if(arr[j1][i1] == arr[j1+1][i1]) {
        						count ++;
        						max = Math.max(max, count);
        					}
        					else {
        						count = 1;
        					}
        				}
        			}
                    temp = arr[j][i];
                    arr[j][i] = arr[j+1][i];
                    arr[j+1][i] = temp;
        		}
        	}
        }
        System.out.println(max);
    }
}