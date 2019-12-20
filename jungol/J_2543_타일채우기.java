
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J_2543_타일채우기 {
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		arr[x][y] = -1;
		slice(0, 0, n);
		arr[x][y] = 0;
		for (int[] a : arr) {
			for (int ar : a) {
				System.out.print(ar + " ");
			}
			System.out.println();
		}
	}

	private static void check(int x, int y, int i) {
		System.out.println(x + " " + y + " " + i);
		slice(x, y, i);
	}
	
	private static void slice(int x, int y, int size) {
		if(size == 2) return;
		
		check(x, y, size/2);
		check(x, y + size/2, size/2);
		check(x + size/2, y, size/2);
		check(x + size/2, y + size/2, size/2);
	}


}
