package boj_17413_단어뒤집기2; // 2022.09.04

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

//	문자열 S가 주어졌을 때, 이 문자열에서 단어만 뒤집으려고 한다.
//	먼저, 문자열 S는 아래와과 같은 규칙을 지킨다.
//
//	알파벳 소문자('a'-'z'), 숫자('0'-'9'), 공백(' '), 특수 문자('<', '>')로만 이루어져 있다.
//	문자열의 시작과 끝은 공백이 아니다.
//	'<'와 '>'가 문자열에 있는 경우 번갈아가면서 등장하며, '<'이 먼저 등장한다. 또, 두 문자의 개수는 같다.
//	태그는 '<'로 시작해서 '>'로 끝나는 길이가 3 이상인 부분 문자열이고, '<'와 '>' 사이에는 알파벳 소문자와 공백만 있다.
//	단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열이고, 연속하는 두 단어는 공백 하나로 구분한다.
//	태그는 단어가 아니며, 태그와 단어 사이에는 공백이 없다.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] str = br.readLine().split("");

		Deque<String> reverse = new ArrayDeque<>(); // 태그가 아닌 문자열을 뒤집어줄 덱
		// 목표 : 태그<>가 포함된 문자열은 sb에 저장해주고, 아닌 문자열은 뒤집어주자!
		for (int idx = 0; idx < str.length; idx++) {
			// 이번 문자가 태그의 여는 괄호(<)라면 닫힌 괄호까지 그대로 sb에 저장
			if (str[idx].equals("<")) {
				while (!str[idx].equals(">"))
					sb.append(str[idx++]);
				sb.append(str[idx]);
			}

			// 이번 문자가 공백이라면 그대로 저장
			else if (str[idx].equals(" "))
				sb.append(str[idx]);

			// 그 외의 문자라면 뒤집도록 해라!
			else {
				while (!(idx == str.length) && !(str[idx].equals(" ") || str[idx].equals("<")))
					reverse.add(str[idx++]);
				while (!reverse.isEmpty())
					sb.append(reverse.pollLast());
				idx--;
			}
		} // 목표 for문 닫히는 곳

		System.out.println(sb);
		br.close();

	} // main
} // class
