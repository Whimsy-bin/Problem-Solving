package boj_1157_단어공부; // 2022.08.13

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

//	알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		word = word.toUpperCase(); // 입력받은 글자들을 대문자로 만들어준다.

		// 알파벳 개수(26)만큼 크기의 배열을 만들어준다. 값을 할당해주지 않았으니 모든 배열의 값은 0으로 저장되어 있다.
		// 0은 A를, 1은 B를, 2는 C를 ... 26은 Z와 일대일 대응한다.
		int[] cnt = new int[26];
//		test

		// 목표 : 단어에 있는 철자와 일치하는 idx의 값을 하나씩 늘려준다.
		for (int i = 0; i < word.length(); i++) {
			cnt[word.charAt(i) - 'A']++;
		}

		int max = 0; // 가장 많이 등장한 알파벳의 갯수를 저장할 변수 선언
		char ans = ' '; // 답을 저장할 변수 선언

		// 목표 : cnt 배열에서 가장 큰 값을 찾아 해당 idx에 대응하는 알파벳을 찾는다.
		for (int j = 0; j < cnt.length; j++) {
			// 해당 배열의 값이 max보다 크면 그 값은 max에, 해당 idx에 대응하는 알파벳은 ans에 저장한다.
			if (max < cnt[j]) {
				max = cnt[j];
				ans = (char) (j + 65);
			}

			// 해당 배열의 값과 max가 같으면 ans에 ?를 저장한다.
			else if (max == cnt[j])
				ans = '?';
		}

		System.out.println(ans);
		br.close();

	} // main
} // class
