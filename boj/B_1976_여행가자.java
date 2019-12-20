import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1976_여행가자 {
	static int[] city;
	static int N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		city = new int[N + 1];
		for(int i = 0; i <= N; i++) city[i] = i;
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp != 0) {
					unionSet(i, j);
				}
			}
		}
		boolean check = true;
		int[] path = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) path[i] = Integer.parseInt(st.nextToken());
		for(int i = 0; i < M - 1; i++) {
			if(findSet(path[i]) != findSet(path[i+1])) {
				check = false;
			}
		}
		if(check) System.out.println("YES");
		else System.out.println("NO");
	}

	private static void unionSet(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		
		if(a != b) city[a] = b;
	}

	private static int findSet(int a) {
		if(city[a] == a) return a;
		else return city[a] = findSet(city[a]);
	}

}
