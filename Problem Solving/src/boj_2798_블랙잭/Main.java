package boj_2798_블랙잭; // 2022.08.20

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

//	카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다. 카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임이다.
//	블랙잭은 카지노마다 다양한 규정이 있다.
//
//	한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.
//	김정인 버전의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다. 그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다. 그런 후에 딜러는 숫자 M을 크게 외친다.
//	이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다.
//	블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.
//
//	N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 카드의 정보를 받아서 LinkedList에 저장해줄게요.
		st = new StringTokenizer(br.readLine());
		List<Integer> card = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			card.add(Integer.parseInt(st.nextToken()));
		}

		int ans = 0; // 답변을 저장할 변수 선언
		// 목표 : 카드 세 장의 합 중에 M보다 크지 않으면서 가장 큰 값을 ans에 저장하기!
		target: for (int j = 0; j <= N - 3; j++) {
			int first = card.get(j); // 1번째 카드 기억!
			for (int k = 0; j + k <= N - 3; k++) {
				int second = card.get(j + k + 1); // 2번째 카드 기억!
				for (int l = 0; j + k + l <= N - 3; l++) {
					int third = card.get(j + k + l + 2); // 3번째 카드 기억!
					int sum = first + second + third; // 세 장의 카드의 값을 모두 더해주어요.
					if (sum < M) // 카드의 합이 M보다 작다면 기존의 저장된 값과 비교해서 큰 수를 저장해주고
						ans = Math.max(ans, sum);
					else if (sum == M) { // 카드의 합이 M과 같다면 바로 목표 for문을 벗어나요!
						ans = sum;
						break target;
					}
				}
			}
		} // 목표 for문이 끝나는 곳

		System.out.println(ans);

	} // main
} // class
