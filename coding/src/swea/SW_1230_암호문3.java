import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SW_1230_암호문3 { // [S/W 문제해결 기본] 8일차 - 암호문3

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		LinkedList<Integer> list = new LinkedList<>();
		for (int t = 1; t <= 10; t++) {
			list.clear();
			int originNum = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < originNum; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			int commandTotalNum = Integer.parseInt(br.readLine());
			int commandNum = 0;
			int point = 0;
			String command;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < commandTotalNum; i++) {
				command = st.nextToken();

				if (command.equals("A")) {
					commandNum = Integer.parseInt(st.nextToken());
					for (int j = 0; j < commandNum; j++) {
						list.addLast(Integer.parseInt(st.nextToken()));
					}
					continue;
				}
				point = Integer.parseInt(st.nextToken());
				commandNum = Integer.parseInt(st.nextToken());

				for (int j = 0; j < commandNum; j++) {
					if (command.equals("D")) {
						list.remove(point);
					} else {
						list.add(point++, Integer.parseInt(st.nextToken()));
					}
				}
			}
			System.out.print("#" + t + " ");
			Iterator<Integer> it = list.iterator();
			int num;
			int cnt = 10;
			while (it.hasNext()) {
				num = it.next();
				System.out.print(num + " ");
				cnt--;
				if (cnt == 0)
					break;
			}
			System.out.println();
		}
	}

}
