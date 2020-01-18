import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_4366_정식이의은행업무2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			char[] bin = br.readLine().toCharArray();
			char[] ter = br.readLine().toCharArray();
			int result = 0;
			
			aa : for(int i = 0; i < bin.length; i++) {
				char tempBin = bin[i];
				if(bin[i] == '0') bin[i] = '1';
				else if(bin[i] == '1') bin[i] = '0';
				
				for(int j = 0; j < ter.length; j++) {
					char tempTer = ter[j];
					
					if(ter[j] == '0') {
						ter[j] = '1';
						
						if(comp(bin, 2) == comp(ter, 3)) {
							result =  comp(bin, 2);
							break aa;
						}
						ter[j] = tempTer;
						
						ter[j] = '2';
						if(comp(bin, 2) == comp(ter, 3)) {
							result = comp(bin, 2); 
							break aa;
						}
						ter[j] = tempTer;
						
					} else if(ter[j] == '1') {
						ter[j] = '0';
						if(comp(bin, 2) == comp(ter, 3)) {
							result = comp(bin, 2);  
							break aa;
						}
						ter[j] = tempTer;
						
						ter[j] = '2';
						if(comp(bin, 2) == comp(ter, 3)) {
							result = comp(bin, 2);  
							break aa;
						}
						ter[j] = tempTer;
						
					} else if(ter[j] == '2') {
						ter[j] = '0';
						if(comp(bin, 2) == comp(ter, 3)) {
							result = comp(bin, 2);  
							break aa;
						}
						ter[j] = tempTer;
						
						ter[j] = '1';
						if(comp(bin, 2) == comp(ter, 3)) {
							result = comp(bin, 2); 
							break aa;
						}
						ter[j] = tempTer;
					}
				}
				bin[i] = tempBin;
			}
			System.out.println("#" + t + " " + result);
		}
	}

	private static int comp(char[] arr, int e) {
		return Integer.parseInt(String.valueOf(arr), e);
	}
	
	

}
