package boj_2559_수열; // 2022.08.19

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		List<Integer> temperature = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			temperature.add(Integer.parseInt(st.nextToken()));
		}

		int sum_First = 0;
		for (int j = 0; j < K; j++) {
			sum_First += temperature.get(j);
		}

		int max = sum_First;
		int sum_Next = sum_First;
		for (int k = 0; k < N - K; k++) {
			sum_Next = sum_Next - temperature.get(k) + temperature.get(k + K);
			max = Math.max(max, sum_Next);
		}

		System.out.println(max);

	} // main
} // class
