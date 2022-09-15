package boj_2869_달팽이는올라가고싶다; // 2022.08.06

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		// 땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.

		// 달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다.
		// 또, 정상에 올라간 후에는 미끄러지지 않는다.

		// 달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.

		// 시간 제한 0.15초

		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(); // 낮에 올라가는 거리 A
		int B = sc.nextInt(); // 밤에 미끄러지는 거리 B
		int V = sc.nextInt(); // 올라가야할 나무 막대의 높이 V

		// 며칠이 걸리는지는 전체 거리를 올라가는 거리로 나누어주면 쉽게 알 수 있다.
		// 여기서 미끄러는 횟수는 항상 올라가는 횟수보다 1회 적으므로 전체 거리는 V에서 B를 한 번 빼주어야 한다.
		int date = (V - B) / (A - B);

		// 그러나 딱 나누어떨어지지 않았을 경우는, 다음 날 올라가야할 조금의 거리가 더 남아있었다는 뜻이므로 date에 1을 더해준다.
		if ((V - B) % (A - B) != 0) {
			date++;
		}
		System.out.println(date);
		sc.close();

	} // main
} // class
