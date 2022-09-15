package boj_1912_연속합; // 2022.08.27

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

//	n개의 정수로 이루어진 임의의 수열이 주어진다.
//	우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다.
//	단, 수는 한 개 이상 선택해야 한다.
//
//	예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 여기서 정답은 12+21인 33이 정답이 된다.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int max = 0;
		int sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (0 <= num) {
				sum += num;
				max = Math.max(max, sum);
			} else {
				sum = 0;
				continue;
			}
		}

		System.out.println(max);
		br.close();

	} // main
} // class