import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int arr[][] = new int[9][9];
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<9; j++) {
            	arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sudoku(0,0);
        

	}
	static void sudoku(int row, int col) {
		if(row == 9) {
            printSudoku();
            System.exit(0);
		}
		int nrow = row;
		if(col == 8) {
			nrow ++;
		}
		int ncol = col+1;
		if(col == 8) {
			ncol = 0;
		}
		if(arr[row][col] != 0) {
			sudoku(nrow, ncol);
		}
		else {
			for(int i=1; i<=9; i++) {
				if(check(row,col,i)) {
					arr[row][col] = i;
					sudoku(nrow,ncol);
					arr[row][col] = 0;
				}
			}
		}
	}
	static void printSudoku() {
        for(int i=0; i<9; i++) {
        	for(int j=0; j<9; j++) {
        		sb.append(arr[i][j]).append(' ');
        	}
        	sb.append('\n');
        }
        System.out.println(sb);
    }
	static boolean check(int row, int col, int num) {
		int x = row/3;
		int y = col/3;
		boolean check2 = true;
		for(int i1 = x*3; i1<x*3+3; i1++) {
			for(int j1 = y*3; j1 <y*3+3; j1++) {
				if(num == arr[i1][j1]) {
					check2 = false;;
				}
			}
		}
		for(int i1=0; i1<9; i1++) {
			if(num == arr[i1][col] || num == arr[row][i1]) {
				check2 = false;
			}
		}
		if(!check2) {
			return false;
		}
		return true;
	}
}
