package SWEA_2805_농작물수확하기; // 2022.08.24

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

//		N X N크기의 농장이 있다.
//		이 농장에는 이상한 규칙이 있다.
//		규칙은 다음과 같다.
//
//	   ① 농장은 크기는 항상 홀수이다. (1 X 1, 3 X 3 … 49 X 49)
//	   ② 수확은 항상 농장의 크기에 딱 맞는 정사각형 마름모 형태로만 가능하다.
//	   
//		농장의 크기 N와 농작물의 가치가 주어질 때, 규칙에 따라 얻을 수 있는 수익은 얼마인지 구하여라.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

//		테스트 케이스의 수 T를 받아서 tc = 1부터 T까지 for문을 돌도록 해요
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc);
			int N = Integer.parseInt(br.readLine());

			int column = N / 2;
			int profit = 0;
			for (int i = 0; i < column; i++) {

			}

			sb.append("\n");
		}

		System.out.println(sb);
		br.close();

	} // main
} // class
