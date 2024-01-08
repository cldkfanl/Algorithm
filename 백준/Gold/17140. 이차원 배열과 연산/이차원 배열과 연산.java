import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int r,c,k;
	static int arr[][];
	static int arr2[][];
	static int count = 0;
	static int xsize = 3;
	static int ysize = 3;
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[100][100];
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
            	arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(arr[r-1][c-1] != k) {
        	if(xsize >= ysize) {
        		combR();
        	}
        	else {
        		combC();
        	}
        	count ++;
        	if(count > 100) {
        		break;
        	}
        }
        if(count >100) {
        	System.out.println(-1);
        }
        else {
            System.out.println(count);
        }
	}
	static void combR() {
		int comp2 = 0;
		for(int i=0; i<xsize; i++) {
			arr2 = new int[101][2];
			for(int j=0; j<ysize; j++) {
				if(arr[i][j] != 0) {
					arr2[arr[i][j]][0] = arr[i][j];
					arr2[arr[i][j]][1]++;
				}
			}
			Arrays.sort(arr2, new Comparator<int[]>() {
			    @Override
			    public int compare(int[] a, int[] b) {
			        if (a[1] == 0 && b[1] != 0) {
			            return 1;
			        }
			        
			        if (a[1] != 0 && b[1] == 0) {
			            return -1;
			        }
			        if (a[1] != 0 && b[1] != 0) {
			            if (a[1] == b[1]) {
			                return a[0] - b[0];
			            } else {
			                return a[1] - b[1];
			            }
			        }
			        return a[0] - b[0];
			    }
			});
			for(int j=0; j<100; j++) {
				if(arr2[j][1] == 0) {
					comp2 = Math.max(comp2, j*2);
					break;
				}
			}
			int num = 0;
			for(int k=0; k<100; k+=2) {
				arr[i][k] = arr2[num][0];
				arr[i][k+1] = arr2[num][1];
				num++;
			}
		}
		if(comp2 >=100) {
			ysize = 100;
		}
		else {
			ysize = comp2;
		}
	}
	static void combC() {
		int comp2 = 0;
		for(int i=0; i<ysize; i++) {
			arr2 = new int[101][2];
			for(int j=0; j<xsize; j++) {
				if(arr[j][i] != 0) {
					arr2[arr[j][i]][0] = arr[j][i];
					arr2[arr[j][i]][1]++;
				}
			}
			Arrays.sort(arr2, new Comparator<int[]>() {
			    @Override
			    public int compare(int[] a, int[] b) {
			        if (a[1] == 0 && b[1] != 0) {
			            return 1;
			        }
			        
			        if (a[1] != 0 && b[1] == 0) {
			            return -1;
			        }
			        if (a[1] != 0 && b[1] != 0) {
			            if (a[1] == b[1]) {
			                return a[0] - b[0];
			            } else {
			                return a[1] - b[1];
			            }
			        }
			        return a[0] - b[0];
			    }
			});
			for(int j=0; j<100; j++) {
				if(arr2[j][1] == 0) {
					comp2 = Math.max(comp2, j*2);
					break;
				}
			}
			int num = 0;
			for(int k=0; k<100; k+=2) {
				arr[k][i] = arr2[num][0];
				arr[k+1][i] = arr2[num][1];
				num++;
			}
		}
		if(comp2 >=100) {
			xsize = 100;
		}
		else {
			xsize = comp2;
		}
	}
}
