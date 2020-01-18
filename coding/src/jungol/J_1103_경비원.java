import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J_1103_경비원 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int total = width * 2 + height * 2;
		
		int n = Integer.parseInt(br.readLine());
		int[] point = new int[n + 1];
		for(int i = 0; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int loc = Integer.parseInt(st.nextToken());
			
			switch(dir) {
			case 1:
				point[i] = loc;
				break;
			case 4:
				point[i] = width + loc;
				break;
			case 2:
				point[i] = width + height + (width - loc);
				break;
			case 3:
				point[i] = width * 2 + height + (height - loc);
				break;
			}
		}
		int result = 0;
		for(int i = 0; i < n; i++) {
			int temp = 0;
			if(point[n] < point[i]) {
				temp = total - point[i] + point[n];
			} else {
				temp = total - point[n] + point[i];
			}
			result += Math.min(temp, Math.abs(point[i] - point[n]));
		}
		System.out.println(result);
	}

}
