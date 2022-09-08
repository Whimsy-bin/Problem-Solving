package SWEA_1989_초심자의회문검사; // 2022.08.12

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws IOException {

//		"level" 과 같이 거꾸로 읽어도 제대로 읽은 것과 같은 문장이나 낱말을 회문(回文, palindrome)이라 한다.
//		단어를 입력 받아 회문이면 1을 출력하고, 아니라면 0을 출력하는 프로그램을 작성하라.
//
//		각 단어의 길이는 3 이상 10 이하이다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스의 수 T를 받아서 tc=1부터 T까지만 while문을 돌도록 합시다.
		int T = Integer.parseInt(br.readLine());
		int tc = 1;
		while (tc <= T) {
			String s = br.readLine(); // 문자열을 먼저 s로 받고
			String str[] = s.split(""); // split함수로 나누어서 str에 철자 하나씩 저장해줍니다.

			// 이제 rev배열에는 입력받은 철자를 거꾸로 저장합시다.
			String rev[] = new String[str.length];
			for (int i = 0; i < str.length; i++) {
				rev[str.length - 1 - i] = str[i];
			}

			// 똑바로 배열(str)과 거꾸로 배열(rev)이 일치하면 1 아니면 0을 저장하도록 하여 출력하고 한 회차를 마쳤으니 tc++을 해줄게요.
			int ans = Arrays.equals(str, rev) ? 1 : 0;
			System.out.println("#" + tc + " " + ans);
			tc++;
		}

		br.close();
	} // main
} // class
