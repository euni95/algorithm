import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17136_색종이붙이기 {
	static int[][] paper;
	static int[] kind = {0, 5, 5, 5, 5, 5};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = 0;
		paper = new int[10][10];
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
				if (paper[i][j] == 1) total++;
			}
		}
		min = Integer.MAX_VALUE;
		go(0, total, 0);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	static int min;

	private static void go(int paperCnt, int total, int tx) {
		if (total == 0) {
			min = Math.min(min, paperCnt);
			return;
		}
		exit: for(int i = tx; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(paper[i][j] == 1) {
					for(int k = 1; k <= 5; k++) {
						if(kind[k] == 0) continue;
						if(findPaper(k, i, j)) {
							for(int x = i; x < i + k; x++) {
								for(int y = j; y < j + k; y++) {
									paper[x][y] = 0;
								}
							}
							kind[k]--;
							go(paperCnt + 1, total - (k * k), i);
							for(int x = i; x < i + k; x++) {
								for(int y = j; y < j + k; y++) {
									paper[x][y] = 1;
								}
							}
							kind[k]++;
						}
					}
					break exit;
				}
			}
		}
	}

	private static boolean findPaper(int size, int x, int y) {
		if (x + size > 10 || y + size > 10) return false;
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (paper[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

}
