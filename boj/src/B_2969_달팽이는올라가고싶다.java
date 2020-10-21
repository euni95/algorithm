import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2969_달팽이는올라가고싶다 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = A - Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken()) - A;
		if(V % B == 0) System.out.println(V / B + 1);
		else System.out.println(V / B + 2);
	}
}
