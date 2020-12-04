import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_13414_수강신청 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken()); // 과목의 수강 가능 인원
		int L = Integer.parseInt(st.nextToken()); // 학생들이 버튼을 클릭한 순서를 기록한 대기목록의 길이
		
		String[] numbers = new String[L];
		for(int i = 0; i < L; i++) numbers[i] = br.readLine();
		
		HashSet<String> set = new HashSet<>();
		Stack<String> stack = new Stack<>();
		for(int i = L - 1; i >= 0; i--) {
			String temp = numbers[i];
			if(!set.contains(temp)) {
				set.add(temp);
				stack.add(temp);
			}
		}
		
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty() && cnt < K) {
			sb.append(stack.pop()).append("\n");
			cnt++;
		}
		
		System.out.println(sb);
	}

}
