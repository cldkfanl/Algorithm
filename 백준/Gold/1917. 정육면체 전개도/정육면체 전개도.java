import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb= new StringBuilder();
	static int arr[][] = new int[6][6];
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            for (int i1 = 0; i1 < 6; i1++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 6; j++) {
                    arr[i1][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (makestring()) {
                sb.append("yes").append('\n');
            } else {
                int count = 4;
                boolean rotated = false;
                while (count-- > 0) {
                    turnright();
                    if (makestring()) {
                        sb.append("yes").append('\n');
                        rotated = true;
                        break;
                    }
                }
                if (!rotated) {
                    flip();
                    if (makestring()) {
                        sb.append("yes").append('\n');
                    } else {
                        int count2 = 4;
                        boolean rotated2 = false;
                        while (count2-- > 0) {
                            turnright();
                            if (makestring()) {
                                sb.append("yes").append('\n');
                                rotated2 = true;
                                break;
                            }
                        }
                        if(!rotated2) {
                        	sb.append("no").append('\n');
                        }
                    }
                }
            }
        }
        System.out.println(sb);
	}
	public static void flip() {
	    int[][] newArr = new int[6][6];

	    for (int i = 0; i < 6; i++) {
	        for (int j = 0; j < 6; j++) {
	            newArr[i][5 - j] = arr[i][j];
	        }
	    }

	    arr = newArr;
	}
	public static void turnright() {
	    int[][] newArr = new int[6][6];
	    
	    for (int i = 0; i < 6; i++) {
	        for (int j = 0; j < 6; j++) {
	            newArr[j][5 - i] = arr[i][j];
	        }
	    }
	    
	    arr = newArr;
	}
	public static boolean makestring() {
    	String x = "";
    	String y = "";
		String stringx = "";
		String stringy = "";
		int minx = 7;
		int miny = 7;
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				if(arr[i][j] == 1) {
    				minx = Math.min(minx, i);
    				miny = Math.min(miny, j);
    				stringx += i;
    				stringy += j;
				}
			}
		}
		for(int k=0; k<6; k++) {
			x += Integer.parseInt(stringx.substring(k,k+1))-minx;
			y += Integer.parseInt(stringy.substring(k,k+1))-miny;
		}
		return testcase(x, y);
	}
	public static boolean testcase(String x, String y) {
		boolean found = false;
		for(int i=1; i<=11; i++) {
			StringBuilder arrx = new StringBuilder();
			StringBuilder arry = new StringBuilder();
			switch(i) {
			case 1 : arrx.append("011112");
			arry.append("001230");
			break;
			case 2 : arrx.append("011112");
			arry.append("101230");
			break;
			case 3 : arrx.append("011112");
			arry.append("201230");
			break;
			case 4 : arrx.append("011112");
			arry.append("301230");
			break;
			case 5 : arrx.append("011112");
			arry.append("101231");
			break;
			case 6 : arrx.append("011112");
			arry.append("201231");
			break;
			case 7 : arrx.append("000111");
			arry.append("234012");
			break;
			case 8 : arrx.append("001122");
			arry.append("231201");
			break;
			case 9 : arrx.append("001112");
			arry.append("230120");
			break;
			case 10 : arrx.append("001112");
			arry.append("011231");
			break;
			case 11 : arrx.append("011122");
			arry.append("101223");
			break;
			}
			if(x.equals(arrx.toString()) && y.equals(arry.toString())) {
				found = true;
				break;
			}
		}
		if(!found) {
			return false;
		}
		return true;
	}
}
