import java.util.Scanner;
import java.util.Stack;


public class SW_5432_쇠막대기자르기 { // 0725 workshop _ 쇠막대기 자르기
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      
      for(int t = 1; t <= T; t++) {
         Stack<Character> stack = new Stack<Character>();
         char[] stick = sc.next().toCharArray();
         int len = stick.length;
         int total = 0;
         
         for(int i = 0; i < len; i++) {
            if(stick[i] == '(') {
            	stack.push(stick[i]);
            	
            	if(stick[i+1] == ')') {
            		stack.pop();
            		total += stack.size();
            	}
            	
            }
            else if(stick[i-1] == ')' && stick[i] == ')') {
            		total++;
            		stack.pop();
            }
         }
         System.out.println("#" + t + " " + total);
         
      }
      sc.close();
   }
}
