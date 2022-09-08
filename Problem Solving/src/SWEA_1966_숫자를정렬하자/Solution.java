package SWEA_1966_숫자를정렬하자; // 2022.08.09

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		// 주어진 N 길이의 숫자열을 오름차순으로 정렬하여 출력하라.
		// N은 5 이상 50 이하이다.

		Scanner sc = new Scanner(System.in);

		// 테스트 케이스의 수 T를 받고 그 숫자까지만 while문을 돌도록 해요.
		int T = sc.nextInt();
		int tc = 1;
		while (tc <= T) {
			System.out.print("#" + tc + " ");

			// 숫자열의 길이 N을 받아서 ArrayList에 저장합니다.
			int N = sc.nextInt();
			List<Integer> arr = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				arr.add(sc.nextInt());
			}

			// 이제 배열에 저장된 숫자 중에 제일 작은 수를 찾아서 출력하는 명령을 N번 수행할 거에요.
			for (int i = 0; i < N; i++) {
				int min = Integer.MAX_VALUE; // 최솟값을 담아둘 min를 선언하여 일단 큰 수를 담아둘게요.
				int index = 0; // 배열의 위치를 파악할 변수도 선언해줍니다.
				
				// 목표 : 가장 작은 수를 찾아서 그 위치를 index에 저장합니다.
				for (int j = 0; j < arr.size(); j++) {
					if (min > arr.get(j)) {
						min = arr.get(j);
						index = j;
					}
				}
				
				// 찾아낸 가장 작은 수를 출력을 하고 그 숫자는 배열에서 지워줍니다.
				System.out.print(arr.get(index) + " ");
				arr.remove(index);
			}
			
			// 줄바꿈을 해주고 한 케이스를 마쳤으니 tc++을 해줄게요.
			System.out.println("");
			tc++;
		}

		sc.close();
	} // main
} // class