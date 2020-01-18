import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J_2634_사냥꾼_answer {

	static class Point implements Comparable<Point> {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			return this.x - o.x;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim());

		int gunCount = Integer.parseInt(st.nextToken());
		int animalCount = Integer.parseInt(st.nextToken());
		int distance = Integer.parseInt(st.nextToken());

		int gun[] = new int[gunCount];
		Point animal[] = new Point[animalCount];

		st = new StringTokenizer(in.readLine().trim());
		for (int i = 0; i < gunCount; i++) {
			gun[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < animalCount; i++) {
			st = new StringTokenizer(in.readLine().trim());
			animal[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(gun);
		Arrays.sort(animal);

		int answer = 0;
		for (int i = 0, j = 0; i < animalCount; i++) { // 동물 기준으로 탐색
			while (j < gunCount && gun[j] < animal[i].x)
				j++; // 마지막 사대 위치를 벗어나지 않으면서 기준동물의 x좌표보다 같거나 큰 사대를 만날때까지 반복
			boolean flag = false;
			//위반복에서 찾은 사대 바로이전 사대로 가능한지 체크
			//j-1 : 현재 동물보다 이전에 있는 사대위치
			if (j > 0 && animal[i].x - gun[j - 1] + animal[i].y <= distance)
				flag = true;
			//위반복에서 찾은 사대로 가능한지 체크
			// j: 현재 동물보다 같거나 다음에 있는 사대위치이거나 현재 동물 이후에 사대가 없는 경우
			if (j < gunCount && gun[j] - animal[i].x + animal[i].y <= distance)
				flag = true;
			if (flag)
				answer++;
		}
		System.out.println(answer);
	}
}
