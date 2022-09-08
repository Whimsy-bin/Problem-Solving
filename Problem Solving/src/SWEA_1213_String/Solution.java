package SWEA_1213_String; // 2022.08.12

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {

//      주어지는 영어 문장에서 특정한 문자열의 개수를 반환하는 프로그램을 작성하여라.
//      Starteatingwellwiththeseeighttipsforhealthyeating,whichcoverthebasicsofahealthydietandgoodnutrition.
//      위 문장에서 ti 를 검색하면, 답은 4이다.
//      
//      총 10개의 테스트 케이스가 주어진다.
//      문장의 길이는 1000자를 넘어가지 않는다.
//      한 문장에서 검색하는 문자열의 길이는 최대 10을 넘지 않는다.
//      한 문장에서는 하나의 문자열만 검색한다. 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스의 수 T는 10이므로 10번까지만 while문을 돌도록 해요.
		int T = 10;
		int tc = 1;
		while (tc <= T) {

			// 테스트 케이스의 번호를 주네요. 받아서 출력해줘요.
			int N = Integer.parseInt(br.readLine());
			System.out.printf("#" + N + " ");

			// 찾을 문자열의 입력을 받아서 target이라는 배열에 한 철자씩 나누어 저장할게요.
			String a = br.readLine();
			String target[] = a.split("");

			// 검색되는 문자열의 입력을 받아서 str이라는 배열에 한 철자씩 나누어 저장할게요.
			String b = br.readLine();
			String str[] = b.split("");

			int ans = 0; // 답을 저장할 변수를 선언해주고
			for (int i = 0; i <= str.length - target.length; i++) {
				int tmp = 0;
				// str[i]와 target[0]을 비교해서 일치하면 그 다음도 일치하는지 살펴보고~
				if (str[i].equals(target[0])) {
					tmp++;
					for (int j = 1; j < target.length; j++) {
						if (str[i + j].equals(target[j]))
							tmp++;
						else
							break;
					}
				}
				// 연속해서 일치한 숫자인 tmp가 target 단어의 길이와 같다면 ans++
				if (tmp == target.length) {
					ans++;
				}
			}
			// ans를 출력해주고 한 회차를 마쳤으니 tc++을 해줄게요.
			System.out.println(ans);
			tc++;
		}

		br.close();
	} // main
} // class