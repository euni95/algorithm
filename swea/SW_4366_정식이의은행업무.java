import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_4366_정식이의은행업무 {
	static char[] bin;
	static char[] ter;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			bin = br.readLine().toCharArray();
			ter = br.readLine().toCharArray();
			
			for(int i = 0; i < bin.length; i++) {
				char tempBin = bin[i];
				if(bin[i] == '0') bin[i] = '1';
				else bin[i] = '1';
				
				if(comp()) {
					break;
				}
				
				bin[i] = tempBin;
			}
			System.out.println("#" + t + " " + Integer.parseInt(String.valueOf(temp), 3));
		}
	}
	
	static char[] temp;
	private static boolean comp() {
		temp = Integer.toString(Integer.parseInt(String.valueOf(bin), 2), 3).toCharArray();
		if(ter.length != temp.length) {
		}
		int cnt = 0;
		for(int k = 0; k < ter.length; k++) {
			if(ter.length != temp.length) break;
			if(temp[k] != ter[k]) {
				cnt++;
			}
		}
		if(cnt == 1) return true;
		else return false;
	}
}
