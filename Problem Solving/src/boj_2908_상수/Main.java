package boj_2908_상수; // 2022.08.06

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// 상근이의 동생 상수는 수학을 정말 못한다. 상수는 숫자를 읽는데 문제가 있다.
		// 수학을 못하는 상수를 위해서 상근이는 수의 크기를 비교하는 문제를 내주었다.
		// 상근이는 세 자리 수 두 개를 칠판에 써주었다. 그 다음에 크기가 큰 수를 말해보라고 했다.

		// 상수는 수를 다른 사람과 다르게 거꾸로 읽는다. 예를 들어, 734와 893을 칠판에 적었다면, 상수는 이 수를 437과 398로 읽는다.
		// 따라서, 상수는 두 수중 큰 수인 437을 큰 수라고 말할 것이다.

		// 두 수가 주어졌을 때, 상수의 대답을 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);

		// 첫 번째로 입력 받은 숫자를 arr1에 저장할 거야
		// 상수는 숫자를 거꾸로 읽으니까 뒤에서부터 저장할 것인데..
		int num1 = sc.nextInt();
		int[] arr1 = new int[3];
		for (int i = 0; i < 3; i++) {
			// 10으로 나눈 나머지를 저장하면 뒤에서부터 한 자리씩 저장할 수 있지
			arr1[i] = (num1 % 10);
			num1 = (num1 / 10);
		}

		// 두 번째로 입력 받은 숫자도 같은 방식으로 arr2에 뒤에서부터 한 자리씩 저장
		int num2 = sc.nextInt();
		int[] arr2 = new int[3];
		for (int i = 0; i < 3; i++) {
			arr2[i] = (num2 % 10);
			num2 = (num2 / 10);
		}

		// 이제 저장된 숫자의 크기를 비교하고 큰 것을 출력
		int j = 0;
		while (j < 3) {
			if (arr1[j] > arr2[j]) {
				System.out.print(arr1[0]);
				System.out.print(arr1[1]);
				System.out.print(arr1[2]);
				break;
			} else if (arr1[j] < arr2[j]) {
				System.out.print(arr2[0]);
				System.out.print(arr2[1]);
				System.out.print(arr2[2]);
				break;
			} else
				j++;
		}

		sc.close();
	} // main
} // class
