import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_4366_정식이의은행업무 {
	static char[] ternary = {'0', '1', '2'};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			char[] two = br.readLine().toCharArray();
			char[] three = br.readLine().toCharArray();
			
			int result = -1;
			for(int i = 0; i < two.length; i++) {
				char two_temp = two[i];
				
				if(two[i] == '0') two[i] = '1';
				else two[i] = '0';
				for(int j = 0; j < three.length; j++) {
					char three_temp = three[j];
					for(int k = 0; k < 3; k++) {
						if(ternary[k] == three_temp) continue;
						three[j] = ternary[k];

						int temp2 = Integer.parseInt(String.valueOf(two), 2);
						int temp3 = Integer.parseInt(String.valueOf(three), 3);
						if(temp2 == temp3) result = temp2;
					}
					three[j] = three_temp;
				}
				two[i] = two_temp;
			}
			System.out.println("#" + t + " " + result);
		}
	}

}
