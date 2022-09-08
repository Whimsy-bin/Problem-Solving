package SWEA_2063_중간값찾기; // 2022.08.09

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		// 중간값은 통계 집단의 수치를 크기 순으로 배열 했을 때 전체의 중앙에 위치하는 수치를 뜻한다.
		// 입력으로 N 개의 점수가 주어졌을 때, 중간값을 출력하라.

		Scanner sc = new Scanner(System.in);

		// 점수의 갯수 N(홀수)을 받고, 점수들을 배열에 일단 다 저장을 해줍니다.
		int N = sc.nextInt();
		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			arr.add(sc.nextInt());
		}

		// 배열 중에 최솟값을 찾아서 중간값 직전까지 삭제해줄거에요.
		int cnt = 1;
		do {
			int min = Integer.MAX_VALUE; // 최솟값을 담아둘 min를 선언하여 일단 큰 수를 담아둘게요.
			int index = 0; // 배열의 위치를 파악할 변수도 선언해줍니다.
			// 목표 : 가장 작은 수도 찾고 그 위치도 index에 저장합니다.
			for (int j = 0; j < arr.size(); j++) {
				if (min > arr.get(j)) {
					min = arr.get(j);
					index = j;
				}
			}

			// 아직 중간값이 등장할 차례가 아니라면 삭제해주고 while문을 계속 돕니다.
			if (cnt < (N + 1) / 2) {
				arr.remove(index);
				cnt++;
			}
			// 중간값 차례라면 출력하고 while 문을 벗어나도록 해요!
			else {
				System.out.println(arr.get(index));
				break;
			}

		} while (true);

		sc.close();

	} // main
} // class