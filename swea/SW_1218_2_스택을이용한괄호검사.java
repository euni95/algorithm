import java.util.Scanner;
import java.util.Stack;

//스택을 이용한 괄호 검사
public class SW_1218_2_스택을이용한괄호검사 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      for(int t = 1; t < 11; t++) {
         int len = sc.nextInt();
         Stack<Character> stack = new Stack<Character>();
         String st = sc.next();
         int result = 1;
         char[] line = st.toCharArray();
         
         
         for(int i = 0; i < len; i++) {
            char d = line[i];
            
            if(d == '(' || d == '[' || d == '{' || d == '<') stack.push(d);
            else {
               if(stack.isEmpty()) {
                  result = 0;
                  continue;
               }
               char checkChar = stack.peek();
               if((checkChar == '(' && d == ')') || (checkChar == '[' && d == ']') 
            		   || (checkChar == '{' && d == '}') || (checkChar == '<' && d == '>')) {
                  stack.pop();
               } else {
                  result = 0;
                  break;
               }
            }
         }
         System.out.println("#" + t + " " + result);
      }
      sc.close();
   }
}