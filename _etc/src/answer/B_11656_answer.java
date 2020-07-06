package answer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//  11656 접미사 배열 백준
public class B_11656_answer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			list.add(s.substring(i));
		}
		Collections.sort(list);
		for (String ss : list) {
			System.out.println(ss);
		}
	}

}
