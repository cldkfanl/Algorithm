import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//스택 구현 후입선출
	public static int[] stack; 
	public static int count = 0;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st;
        
        int a = Integer.parseInt(br.readLine());
    	stack = new int[a];
    	while(a-- >0) {  //입력값 a만큼 반복
        		
    		st = new StringTokenizer(br.readLine(), " ");
            	
    		switch(st.nextToken()) { //동작에 맞는 함수 실행
    		case "push":
    			push(Integer.parseInt(st.nextToken()));
    			break;
            		
    		case "pop" :
    			sb.append(pop()).append('\n');
    			break;
            		
    		case "size" :
    			sb.append(size()).append('\n');
    			break;
    			
    		case "empty" :
    			sb.append(empty()).append('\n');
    			break;
    			
    		case "top" :
    			sb.append(top()).append('\n');
    			break;
    			}
    		}
    	System.out.println(sb);
    	}
	public static void push(int item) { //push
		stack[count] = item;            //값 입력
		count ++;
	}
	public static int pop() {           //마지막 값 뽑아서 리턴
		if(count == 0) {                //만약 스택이 비어있으면
			return -1;                  //-1 리턴
		}
		else {
			int output = stack[count-1];
			stack[count-1] = 0;
			count --;
			return output;
		}
	}
	public static int size() {           //스택 크기 리턴
		return count;
		
	}
	public static int empty() {          //스택이 비어있으면
		if(count == 0) {                 // 1 리턴
			return 1;
		}
		else {                           //아니면 0 리턴
			return 0;
		}
		
	}
	public static int top() {            //마지막 값 리턴
		if(count == 0) {                 //비어있으면 -1 리턴
			return -1;
		}
		else {
			return stack[count-1];
		}
	}
}
