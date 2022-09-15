package SWEA_7087_문제제목붙이기; // 2022.08.28

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

//	매번 혼자서 알고리즘 문제를 풀던 은기와 자영이는, 많은 사람들의 즐거움을 주기 위해 프로그래밍 대회를 개최하려고 한다.
//	은기와 자영이는 대회에 사용할 문제를 준비하는 과정에서 문제 제목을 정하게 되었다.
//	은기는 대회의 문제들에 사용할 수 있는 제목을 N개 만들었다.
//	자영이는 제목의 가장 앞 글자에 알파벳 대문자 A부터 시작하여, A, B, C, … , Z가 순서대로 한 번씩 등장하면 좋겠다고 하였다.
//	만약 도중에 특정 알파벳이 문제 제목의 맨 앞 글자로 등장하지 않으면 그 이후의 알파벳은 사용하지 않는다.
//	예를 들어, 문제 제목으로 Air, Dad, Ear, Blue, Ace가 있다면, A와 B는 등장하였지만, C는 등장하지 않았기 때문에 최대 2개의 문제 제목을 사용할 수 있는 것이다.
//	은기가 만든 문제들의 제목이 주어질 때, 자영이가 정한 규칙에 따라서 사용할 수 있는 최대 문제 제목의 개수를 계산하는 프로그램을 작성하라.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스의 수 T를 받아서 tc = 1부터 T까지 for문을 돌도록 해요.
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			// 입력 받은 제목 후보들을 저장할 거에요.
			List<Character> title = new ArrayList<>();
			for (int i = 0; i < N; i++)
				title.add(br.readLine().charAt(0)); // 알파벳 맨 앞 대문자만 저장하기

			char alphabet = 'A'; // 이번에 찾아볼 알파벳
			// 목표 : 알파벳 A부터 Z까지 한 번씩 등장하는지 확인해보자!
			target: while (alphabet != 'Z' + 1) {

				boolean check = true; // 목표 알파벳이 나왔는지 아닌지 확인!
				for (int j = title.size() - 1; 0 <= j; j--) {
					if (title.get(j) == alphabet) {
						check = false;
						title.remove(j);
					}
				}
				if (check)
					break target;
				
				alphabet++; // 다음 알파벳을 살펴보아요~
			} // 목표 while문 끝나는 곳
			
			int ans = alphabet - 'A';
			sb.append("#" + tc + " ").append(ans).append("\n");
		}

		System.out.println(sb);
		br.close();

	} // main
} // class
