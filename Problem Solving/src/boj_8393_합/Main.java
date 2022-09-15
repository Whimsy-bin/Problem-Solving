package boj_8393_합; // 2022.09.09 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

//	n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		for (int i = 1; i <= n; i++)
			sum += i;

		System.out.println(sum);
		br.close();

	} // main
} // class
