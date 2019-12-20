import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_2798_블랙잭_comb {
	static int N, M;
	static int[] card;
	static boolean[] flag;
	static ArrayList<Integer> temp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		card = new int[N];
		flag = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			card[i] = Integer.parseInt(st.nextToken());

		max = 0;
		temp = new ArrayList<>();
		comb(N - 1, 3, 0);
		System.out.println(max);
	}

	private static void comb(int n, int r, int depth) {
		if (r == depth) {
			calc();
			return;
		}

		for (int i = 0; i <= n; i++) {
			if (flag[i]) continue;
			if (temp.size() != 0 && temp.get(temp.size() - 1) > i) continue;

			flag[i] = true;
			temp.add(i);
			comb(n, r, depth + 1);
			temp.remove(temp.size() - 1);
			flag[i] = false;
		}
	}
	
	static int max;
	private static void calc() {
		int sum = 0;
		for(int i = 0; i < 3; i++) {
			sum += card[temp.get(i)];
		}
		System.out.println();
		if(sum <= M && max < sum) max = sum;
	}

}
