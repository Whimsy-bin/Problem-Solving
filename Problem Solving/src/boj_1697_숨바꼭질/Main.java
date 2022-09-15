package boj_1697_숨바꼭질; // 2022.09.05

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

//	수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
//	수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
//	순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
//
//	수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
		int K = Integer.parseInt(st.nextToken()); // 동생의 위치

		if (N < K) {

			int[] time = new int[K + 2]; // 해당 점에 가장 빠르게 도착한 시간을 저장할 배열 선언

			// 초기 수빈이의 위치의 양 옆과 2*N의 위치가 존재하면 해당 점들의 시간 값에는 1을 저장해둔다.
			if (0 <= N - 1)
				time[N - 1] = 1;
			if (N + 1 < time.length)
				time[N + 1] = 1;
			if (N * 2 < time.length)
				time[N * 2] = 1;

			int movement = 1; // 움직임의 횟수를 저장할 변수
			// 목표 : 현재 배열의 값을 확인하여 움직임의 횟수와 같다면 양옆과 두 배 한 곳의 값들을 1 높은 값으로 저장해준다.
			while (true) {
				int next = movement + 1; // 저장할 값
				for (int i = 0; i < time.length; i++) {
					// 저장을 할 때는 값이 없을 때(0일 때)만 저장하도록 한다.
					if (time[i] == movement) {
						if (0 <= i - 1)
							time[i - 1] = (time[i - 1] == 0) ? next : time[i - 1];
						if (i + 1 < time.length)
							time[i + 1] = (time[i + 1] == 0) ? next : time[i + 1];
						if (i * 2 < time.length)
							time[i * 2] = (time[i * 2] == 0) ? next : time[i * 2];
					}
				}
				// 동생이 있는 곳까지 도달했다면 더 이상 움직일 필요가 없다.
				if (time[K] != 0)
					break;

				movement++;
			} // 목표 while문 끝나는 곳

			System.out.println(time[K]);

		} else
			System.out.println(N - K);
		
		br.close();

	} // main
} // class