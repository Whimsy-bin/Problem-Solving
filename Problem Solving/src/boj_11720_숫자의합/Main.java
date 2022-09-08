package boj_11720_숫자의합; // 2022.08.06

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 여기서 int도 long도 double도 안되네
		String num = sc.next();
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			ans += num.charAt(i)-'0';
		}
		
		System.out.println(ans);
		
		sc.close();
	} // main
} // class
