package SWEA_3499_퍼펙트셔플; // 2022.08.18

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

//	카드를 퍼펙트 셔플 한다는 것은, 카드 덱을 정확히 절반으로 나누고 나눈 것들에서 교대로 카드를 뽑아 새로운 덱을 만드는 것을 의미한다. 
//	N개의 카드가 있는 덱이 주어질 때 이를 퍼펙트 셔플하면 어떤 순서가 되는지 출력하는 프로그램을 작성하라.
//
//	만약 N이 홀수이면, 교대로 놓을 때 먼저 놓는 쪽에 한 장이 더 들어가게 하면 된다.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스의 수 T를 받아서 tc=1부터 T까지 for문을 돌도록 해요.
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#" + tc);

			// 나눗셈을 할 거라서 카드의 수 N을 double형으로 받을겁니다.
			double N = Integer.parseInt(br.readLine());
			// 홀수일 때는 올림이 되도록 해주어요.
			int half = (int) Math.ceil(N / 2);

			// 주어진 카드의 정보를 받아서 띄어쓰기 단위로 끊어서 배열에 저장할게요.
			String str = br.readLine();
			String[] card = str.split(" ");

			// 목표 : 위에서 구해준 half부분을 기준으로 교대로 왔다갔다 출력하기.
			for (int i = 0; i < half; i++) {
				try {
					System.out.print(" " + card[i] + " ");
					System.out.print(card[half + i]);
					
				} 
				// N이 홀수일 때는 없는 배열을 참조하려는 오류가 발생할 수 있으므로 건너뛰도록 설정해줍니다.
				catch (ArrayIndexOutOfBoundsException e) {
					continue;
				}
			} // 목표 for문이 닫히는 곳

			// 줄 바꿈해주면서 한 회차 끝!
			System.out.println("");
		}

	} // main
} // class
