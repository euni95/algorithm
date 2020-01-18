import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_3499_퍼펙트셔플 { // 퍼펙트 셔플

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int cnt = Integer.parseInt(br.readLine());
			System.out.print("#" + t + " ");

			String[] line = br.readLine().split(" ");
			int size = 0, num = 0;
			if(cnt % 2 == 1) size = cnt / 2 + 1;
			else size = cnt / 2;
			num = size;
			
			for(int i = 0; i < num; i++) {
				System.out.print(line[i] + " ");
				
				if(cnt % 2 == 1 && i == num -1) break;
				System.out.print(line[size++] + " ");
			}
			System.out.println(); 
		}
	}

}
