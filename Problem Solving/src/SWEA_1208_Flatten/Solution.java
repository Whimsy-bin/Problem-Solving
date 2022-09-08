package SWEA_1208_Flatten; // 2022.08.09

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

//		한 쪽 벽면에 다음과 같이 노란색 상자들이 쌓여 있다.
//		높은 곳의 상자를 낮은 곳에 옮기는 방식으로 최고점과 최저점의 간격을 줄이는 작업을 평탄화라고 한다.
//		평탄화를 모두 수행하고 나면, 가장 높은 곳과 가장 낮은 곳의 차이가 최대 1 이내가 된다.
//		평탄화 작업을 위해서 상자를 옮기는 작업 횟수에 제한이 걸려있을 때, 제한된 횟수만큼 옮기는 작업을 한 후 최고점과 최저점의 차이를 반환하는 프로그램을 작성하시오.

//		가로 길이는 항상 100으로 주어진다.
//		모든 위치에서 상자의 높이는 1이상 100이하로 주어진다.
//		덤프 횟수는 1이상 1000이하로 주어진다.
//		주어진 덤프 횟수 이내에 평탄화가 완료되면 더 이상 덤프를 수행할 수 없으므로 그 때의 최고점과 최저점의 높이 차를 반환한다 (주어진 data에 따라 0 또는 1이 된다).

		Scanner sc = new Scanner(System.in);

		// 10개의 testcase가 주어지므로 tc가 1부터 10이 될때까지만 while문을 돌도록 합시다.
		int T = 10;
		int tc = 1;
		while (tc <= T) {
			System.out.print("#" + tc + " ");
			int N = sc.nextInt(); // 덤프 제한횟수를 받습니다.

			// 상자의 높이 정보들을 받아서 배열에 저장할게요.
			List<Integer> box = new ArrayList<>();
			for (int i = 0; i < 100; i++) {
				box.add(sc.nextInt());
			}

			// 이제 배열에 저장된 숫자 중에 제일 작은 수와 제일 큰 수를 찾아서 덤프 과정을 수행할 겁니다.
			int min = 100; // 최솟값을 담아둘 min를 선언(상자 높이의 최댓값은 100)
			int max = 1; // 최댓값을 담아둘 max를 선언(상자 높이의 최솟값은 1)
			int min_idx = 0; // 최솟값이 있는 배열의 위치를 파악할 변수 선언
			int max_idx = 0; // 최댓값이 있는 배열의 위치를 파악할 변수 선언
			for (int j = 1; j <= N; j++) {
				// 목표 : 가장 큰 수와 작은 수를 찾고 배열에서의 위치도 각각 idx에 저장합니다.
				for (int k = 0; k < box.size(); k++) {
					if (min > box.get(k)) {
						min = box.get(k);
						min_idx = k;
					}
					if (max < box.get(k)) {
						max = box.get(k);
						max_idx = k;
					}
				}

				// 상자가 가장 많은 곳에서 상자를 하나 뺴어 가장 상자가 가장 적은 곳으로 옮겨줍니다.
				if (max - min > 1) {
					box.set(max_idx, --max);
					box.set(min_idx, ++min);
				} else
					break;
			} // 덤프 과정을 수행 1회 끝!

			// 평탄화를 마치면, 그 이후에 새로 max와 min를 찾아보아요.
			for (int l = 0; l < box.size(); l++) {
				if (min > box.get(l))
					min = box.get(l);
				else if (max < box.get(l))
					max = box.get(l);
			}

			// 최고점과 최저점의 높이 차를 출력하고, 한 케이스를 마쳤으니 tc++을 해줄게요.
			System.out.println(max - min);
			tc++;
		}

		sc.close();
	} // main
} // class
