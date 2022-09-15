package SWEA_1288_새로운불면증치료법; // 2022.08.28

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

//	민석이는 불면증에 걸렸다. 그래서 잠이 안 올 때의 민간요법 중 하나인 양 세기를 하려고 한다.
//	민석이는 1번 양부터 순서대로 세는 것이 재미없을 것 같아서 N의 배수 번호인 양을 세기로 하였다.
//	즉, 첫 번째에는 N번 양을 세고, 두 번째에는 2N번 양, … , k번째에는 kN번 양을 센다.
//	이렇게 숫자를 세던 민석이에게 잠은 더 오지 않고 다음과 같은 궁금증이 생겼다.
//
//	이전에 셌던 번호들의 각 자리수에서 0에서 9까지의 모든 숫자를 보는 것은 최소 몇 번 양을 센 시점일까?

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 테스트 케이스의 수 T를 받아서 tc=1부터 T까지 for문을 돌도록 해요
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int x = 1;
			int[] num = new int[10];
			target: while (true) {
				int tmp = x * N;
				while (tmp != 0) {
					int rest = tmp % 10;
					num[rest]++;
					tmp /= 10;
				}
				for (int i = 0; i < 10; i++) {
					if (num[i] == 0)
						break;
					if (i == 9)
						break target;
				}
				x++;
			}

			sb.append("#" + tc + " ").append(x*N).append("\n");
		}

		System.out.println(sb);
		br.close();

	} // main
} // class
