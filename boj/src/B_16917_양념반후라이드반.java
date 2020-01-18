import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16917_양념반후라이드반 {
	static int A, B, C, X, Y;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		if((C * 2 < A + B) && (X > 0) && (Y > 0)) {
			int min = Math.min(X, Y);
			sum = sum + min * 2 * C;
			X -= min;
			Y -= min;
		}
		if(C * 2 < A) {
			sum += C * 2 * X;
			X = 0;
		}
		if(C * 2 < B) {
			sum += C * 2 * Y;
			Y = 0;
		}
		sum += A * X + B * Y;
		System.out.println(sum);
	}

}
