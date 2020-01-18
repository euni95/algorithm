import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_1158_조세퍼스 { // 조세퍼스 문제

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1; i <= N; i++) list.add(i);
		
		int idx = 0;
		System.out.print("<");
		while(list.size() != 0) {
			idx = (idx + K - 1) % list.size();
			
			if(list.size() == 1) System.out.print(list.get(idx));
			else System.out.print(list.get(idx) + ", ");
			list.remove(idx);
		}
		System.out.print(">");
	}

}
