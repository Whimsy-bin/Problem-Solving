package boj_11656_접미사배열; // 2022.09.08

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

//	접미사 배열은 문자열 S의 모든 접미사를 사전순으로 정렬해 놓은 배열이다.
//
//	baekjoon의 접미사는 baekjoon, aekjoon, ekjoon, kjoon, joon, oon, on, n 으로 총 8가지가 있고,
//	이를 사전순으로 정렬하면 aekjoon, baekjoon, ekjoon, joon, kjoon, n, on, oon이 된다.
//
//	문자열 S가 주어졌을 때, 모든 접미사를 사전순으로 정렬한 다음 출력하는 프로그램을 작성하시오.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		sb.append(br.readLine()); // 문자열을 sb에 저장해두자.
		int size = sb.length(); // 모든 접미사의 갯수

		String[] str_part = new String[size]; // 모든 접미사를 저장할 배열 선언
		// 목표 : sb에 저장된 문자열을 앞에서 한 문자씩 지우면서 모든 접미사를 찾아 배열에 저장하자.
		for (int i = 0; i < size; i++) {
			str_part[i] = sb.toString();
			sb.delete(0, 1);
		}
		
		// 접미사들이 저장된 배열을 정렬하자.
		Arrays.sort(str_part);

		// 정렬된 접미사들을 주어진 형식에 맞추어 sb에 저장하고 출력하면 끝~
		for (int k = 0; k < size; k++)
			sb.append(str_part[k]).append("\n");

		System.out.println(sb);
		br.close();

	} // main
} // class
