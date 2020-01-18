import java.util.Scanner;

public class SW_7272_안경이없어 { //0725 workshop _ 안경이 없어!

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			String checkA = "";
			String checkB = "";
			String result;
			
			char[] arrA = sc.next().toCharArray();
			char[] arrB = sc.next().toCharArray();
			
			if(arrA.length != arrB.length) {
				System.out.println("#" + t + " DIFF");
				continue;
			}
			
			for(int i = 0; i < arrA.length; i++) {
				checkA += check(arrA[i]);
				checkB += check(arrB[i]);
			}
			
			if(checkA.equals(checkB)) result = "SAME";
			else result = "DIFF";
			
			System.out.println("#" + t + " " + result);
		}

	}
	public static String check(char c) {
		if(c == 'A' || c == 'D' || c == 'O' || c == 'P' || c == 'Q' || c == 'R') {
			return "0";
		}
		else if(c == 'B') {
			return "1";
		}
		else return "2";
	}

}
