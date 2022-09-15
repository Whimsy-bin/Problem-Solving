package boj_11655_ROT13; // 2022.09.07

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

//	ROT13은 카이사르 암호의 일종으로 영어 알파벳을 13글자씩 밀어서 만든다.
//
//	예를 들어, "Baekjoon Online Judge"를 ROT13으로 암호화하면 "Onrxwbba Bayvar Whqtr"가 된다. =
//	ROT13으로 암호화한 내용을 원래 내용으로 바꾸려면 암호화한 문자열을 다시 ROT13하면 된다.
//	앞에서 암호화한 문자열 "Onrxwbba Bayvar Whqtr"에 다시 ROT13을 적용하면 "Baekjoon Online Judge"가 된다.
//
//	ROT13은 알파벳 대문자와 소문자에만 적용할 수 있다. 알파벳이 아닌 글자는 원래 글자 그대로 남아 있어야 한다.
//	예를 들어, "One is 1"을 ROT13으로 암호화하면 "Bar vf 1"이 된다.
//
//	문자열이 주어졌을 때, "ROT13"으로 암호화한 다음 출력하는 프로그램을 작성하시오.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] str = br.readLine().toCharArray();

		// 목표 : ROT13 암호화를 진행한다.
		for (int i = 0; i < str.length; i++) {
			// 숫자거나 공백이면 그대로 sb에 저장한다.
			if (('0' <= str[i] && str[i] <= '9') || str[i] == ' ')
				sb.append(str[i]);

			// 알파벳이면 13번째인 m과 M까지는 13을 더해주고, 아니면 13을 빼준다.
			else {
				if (('a' <= str[i] && str[i] <= 'm') || ('A' <= str[i] && str[i] <= 'M'))
					sb.append((char) (str[i] + 13));
				else
					sb.append((char) (str[i] - 13));
			}
		}

		System.out.println(sb);
		br.close();

	} // main
} // class