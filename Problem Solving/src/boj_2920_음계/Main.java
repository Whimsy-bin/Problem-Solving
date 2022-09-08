package boj_2920_음계; // 2022.08.06

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

//			다장조는 c d e f g a b C, 총 8개 음으로 이루어져있다.
//			이 문제에서 8개 음은 다음과 같이 숫자로 바꾸어 표현한다. c는 1로, d는 2로, ..., C를 8로 바꾼다.

//			1부터 8까지 차례대로 연주한다면 ascending, 8부터 1까지 차례대로 연주한다면 descending, 둘 다 아니라면 mixed 이다.

//			연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지, 아니면 mixed인지 판별하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);

		// 일단은 주어지는 8개의 숫자를 배열에 담아보겠어
		int arr[] = new int[8];
		for (int i = 0; i < 8; i++) {
			arr[i] = sc.nextInt();
		}

		int j = 0; // j번째 배열의 숫자가
		int k = 1; // k인지 확인하기 위해서 이렇게 숫자를 주어보았다.
		String ans = ""; // 요것은 정답을 저장하는 문자열

		if (arr[j] == k) {
			// 일단 첫번째 숫자가 1이면 ascending일 가능성이 있으니 확인
			while (j < 7) {
				j++;
				k++;
				if (arr[j] == k) {
					ans = "ascending";
				} else {
					ans = "mixed";
					break;
				}
			}
		} else if (arr[7 - j] == k) {
			// 마지막 숫자가 1이면 descending일 가능성이 있으니 확인
			while (j < 7) {
				j++;
				k++;
				if (arr[7 - j] == k) {
					ans = "descending";
				} else {
					ans = "mixed";
					break;
				}
			}
		} else {
			// 둘 다 아니면 바로 mixed잖아!
			ans = "mixed";
		}
		System.out.println(ans);

		sc.close();
	} // main
}
// class
