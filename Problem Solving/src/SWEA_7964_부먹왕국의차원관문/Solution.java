package SWEA_7964_부먹왕국의차원관문; // 2022.08.24

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

//	부먹 왕국은 찍먹 무리에게 침략을 당했었다.
//	하지만 탕수육의 힘으로 성공적으로 막아 내었으나 도시의 많은 차원관문이 파괴당했다.
//	부먹 왕국의 특징은 모든 도시들을 건설 할 때 일렬로 이어지게 만들었다.
//	어느 도시에 차원 관문을 설치하면 그 도시와 거리 D 이하인 다른 도시에서 차원 관문이 있는 곳으로 들어오거나, 혹은 차원 관문에서 거리 D 이하인 다른 도시로 나가는것이 가능하다.
//	찍먹 왕국의 재침공에 대비하기 위해서 모든 도시 이동이 되어야하며 모든 차원 관문 사이와 직접적으로 이동이 가능하도록 차원 관문을 재건하려고 한다.
//	(단, 0번 위치와 N+1번 위치에는 차원 관문이 존재 한다.)
//	가능한 빠른 건설을 위하여 최소 개수로 설치하는 계획을 세우려고 할때
//
//	도시들마다 차원관문이 남아있는 지에 대한 정보가 주어졌을 때, 이동에 필요한 차원관문의 최소 개수를 구하여

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

//		테스트 케이스의 수 T를 받아서 tc = 1부터 T까지 for문을 돌도록 해요
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 부먹 왕국의 도시 수
			int D = Integer.parseInt(st.nextToken()); // 차원관문의 이동 제한 거리
			List<Integer> city = new ArrayList<>(); // 도시의 차원관문 정보를 받을 city 배열 선언 
			st = new StringTokenizer(br.readLine());
			city.add(1); // 0번 위치에는 차원관문이 있다.
			for (int i = 0; i < N; i++)
				city.add(Integer.parseInt(st.nextToken()));
			city.add(1); // N+1번 위치에도 차원관문이 있다.

			// 목표 : 차원관문이 파괴당한 도시가 연속되어 있는 곳을 D로 나눠주어 추가 차원관문을 얼마나 설치해야 할지 구하자
			int gateway = 0; // 추가로 건설해야 하는 차원관문의 갯수를 저장할 변수
			int destroy = 0; // 연속된 차원관문이 파괴당한 도시의 수를 저장할 변수 
			for (int j = 0; j < N + 2; j++) {
				// 해당 도시가 차원관문이 파괴당한 도시면 destroy ++
				if (city.get(j).equals(0))
					destroy++;
				// 해당 도시에 차원관문이 있으면 이전 도시까지 얼마나 연속되어 파괴당해있는지 정보와 차원관문의 이동 제한 거리 정보를 이용해 gateway에 더해줌
				else {
					gateway += (destroy / D);
					destroy = 0;
				}
			} // 목표 for문 닫히는 곳

			// 한 회차가 끝났으니 답변과 줄바꿈을 sb에 추가해준다.
			sb.append(gateway).append("\n");
		}

		System.out.println(sb);
		br.close();

	} // main
} // class