import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class SW_3501_순환소수짧게표현하기_answer{
	static int startIdx, p, q, q2, a, b;
	public static void main(String[] args) throws IOException{
//		        System.setIn(new FileInputStream("sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String result = "";
		int divider = 0;
		for(int test_case = 1; test_case <= T; test_case++) {
			p = sc.nextInt();
			q = sc.nextInt();
			//정수면 출력
			if (p % q == 0) {
				System.out.print("#" + test_case + " " + p/q + "\n");
				continue;
			}
//			 최대공약수를 구해서 나누어 주고 
			divider = gcd(p,q);
	        p /= divider;
	        q /= divider;

			StringBuilder sb = new StringBuilder();
			if(checkCirc()) {    // 유한소수이면 그대로 문자열 만들어 출력
//				sb.append(Double.valueOf(x)/y);  자바 실수 연산의 한계  때문인지 정상처리 되지 않음
				sb.append( p/q );
				p = (p%q)*10;
				if(p != 0)
					sb.append(".");
				while(p != 0) {
					sb.append(p/q);
					p = (p%q)*10;
				}
			} else {    // 순환소수일 때
				int length = getCircularLength();    // 순환 부분 길이
				sb.append( p / q );                    // 처음 시작 계산하고 출력
				sb.append(".");                    // 처음 시작 계산하고 출력
				for(int i=0; i<startIdx; i++) {    // 순환 시작 위치까지는 그냥 계산해서 출력
					p = (p % q) * 10;
					sb.append(p/q);
				}
				sb.append("("); //순환 부분 괄호안으로 표시
				for(int i=0; i<length; i++) {
					p = (p % q) * 10;
					sb.append( p / q);
				}
				sb.append(")");    
			}

			result = sb.toString();
			System.out.println("#"+test_case+" "+result);
		}
	}
	static boolean checkCirc() {    // 순환인지 비순환인지 확인
		int p2 = p;
		int q3 = q;
		a = 0;
		b = 0;
		
//		중2 수학정리라고 하내요
//		https://m.blog.naver.com/vusgowlwk/220741488806
//		분모에 2 또는 5로만 구성이
//		되어있는 분수들은 똑 떨어지는 유한소수가 되고,
//		그렇지 않은 분수의 경우는 무한소수가 된다.
		
		while(q3%2 == 0) {
			q3 /= 2;
			a++;
		}

		while(q3%5 == 0) {
			q3 /= 5;
			b++;
		}
		q2 = q3;

		if(q2 == 1)
			return true;
		else
			return false;
	}
	static int gcd(int n1, int n2) {    // 최대공약수
	    int c;
	    while (n2 != 0) {
	        c = n1 % n2;
	        n1 = n2;
	        n2 = c;
	    }
	    return n1;
	}
	static int getCircularLength() {    // 순환 길이 계산
		int n=1;
		int target = 9;

		startIdx = a>b ? a : b;    // 순환 시작 위치 계산

		while((target %= q2) != 0) {
			n++;
			target = target*10 + 9;
		}
		return n;
	}

}