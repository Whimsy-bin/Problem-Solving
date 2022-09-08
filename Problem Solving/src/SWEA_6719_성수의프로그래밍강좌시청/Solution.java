package SWEA_6719_성수의프로그래밍강좌시청; // 2022.08.03

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 여러 개의 Test case가 주어지므로 각각을 처리해보자
		for (int t = 1; t <= T; t++) {

			int N = sc.nextInt(); // 볼 수 있는 강의의 수
			int K = sc.nextInt(); // 내가 볼 강의의 수

			List<Integer> Lecture = new ArrayList<>(); // 강의의 수준을 저장할 배열 생성
			// lecture 배열에 입력받은 각 강의의 수준을 저장하자
			for (int i = 0; i < N; i++) {
				Lecture.add(sc.nextInt());
			}

			Collections.sort(Lecture); // 강의의 수준이 담긴 배열의 순서를 오름차순으로 정렬해야지!

			// 내 실력을 최대로 하려면 배열의 뒤쪽의 K개를 오름차순 순서대로 들어야하네
			double A = 0; // 소숫점까지 출력해야하니까 내 실력 A는 double로 처리해야하는군!
			for (int j = 0; j < K; j++) {
				A = (A + Lecture.get(N - K + j)) / 2;
			}
			// 오차가 10^(-6) 이하이면 정답으로 인정하니까 소수점 6자리까지 반올림하여 출력해야지
			System.out.println("");
			System.out.printf("#%d %.6f", t, A);
		}
		sc.close();
		
	} // main
} // class