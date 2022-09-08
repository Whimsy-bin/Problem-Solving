package SWEA_1860_진기의최고급붕어빵; // 2022.08.21

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

//	진기는 붕어빵 가게를 운영하고 있다.
//	진기가 파는 붕어빵은 그냥 붕어빵이 아니라 겉은 바삭! 속은 말랑! 한입 물면 팥 앙금이 주르륵 흘러 입안에서 춤을 추며,
//	절로 어릴 적 호호 불며 먹었던 뜨거운 붕어빵의 추억이 떠올라 눈물이 나오게 되는 최고급 붕어빵이다.
//	
//	진기는 이런 붕어빵을 보통 사람들에게는 팔지 않는다.
//	그는 무조건 예약제로만 손님을 받으며, 예약을 하려는 손님들은 진기의 까다로운 자격 검증에서 합격해야만 붕어빵을 맛 볼 자격을 얻는다.
//
//	그래서 오늘은 N명의 사람이 자격을 얻었다.
//	진기는 0초부터 붕어빵을 만들기 시작하며, M초의 시간을 들이면 K개의 붕어빵을 만들 수 있다.
//	서빙은 진기가 하는 것이 아니기 때문에, 붕어빵이 완성되면 어떤 시간 지연도 없이 다음 붕어빵 만들기를 시작할 수 있다.
//	0초 이후에 손님들이 언제 도착하는지 주어지면, 모든 손님들에게 기다리는 시간없이 붕어빵을 제공할 수 있는지 판별하는 프로그램을 작성하라.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// tc = 1 부터 T 까지 for문을 돌도록 하자
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 이번 테스트케이스에서 방문할 손님의 수
			int M = Integer.parseInt(st.nextToken()); // 한 번 붕어빵을 만드는 데에 걸리는 시간
			int K = Integer.parseInt(st.nextToken()); // 한 번에 만들어지는 붕어빵의 수

			// 손님들이 방문하는 시간 정보를 배열에 저장해주고 파악이 쉽도록 시간 순으로 정렬해두자.
			st = new StringTokenizer(br.readLine());
			List<Integer> guest = new ArrayList<>();
			for (int i = 0; i < N; i++)
				guest.add(Integer.parseInt(st.nextToken()));
			Collections.sort(guest);

			String ans = "Possible";
			int time = 0; // 시간
			int num = 0; // 붕어빵의 갯수

			// 목표 : M마다 붕어빵의 수를 K개 늘려주고, 손님이 방문하는 시간이 되면 하나를 판매하자.
			sale: while (true) {

				// 다음 붕어빵이 만들어지기 전까지 손님들이 찾아오면 기존에 있던 붕어빵들을 판매해야 한다.
				while (time + M - 1 >= guest.get(0)) {
					// 이 때 붕어빵이 없으면 바로 Impossible을 출력하러 가자.
					if (num-- == 0) {
						ans = "Impossible";
						break sale;
					}
					guest.remove(0); // 붕어빵을 가져간 손님의 정보는 배열에서 빼준다.
					// 배열이 비어있다면 찾아올 손님이 더이상 없으므로 while문을 벗어난다.
					if (guest.isEmpty())
						break sale;
				}
				time += M;
				num += K;

			} // 목표 while문이 끝나는 곳

			// 붕어빵을 제공할 수 있는지 없는지 여부를 sb에 저장해주면서 한 회차를 마친다.
			sb.append("#" + tc + " ").append(ans).append("\n");
		}

		// 출력해주면 끝!
		System.out.println(sb);
		br.close();

	} // main
} // class
