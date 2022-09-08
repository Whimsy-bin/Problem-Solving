package SWEA_5356_의석이의세로로말해요; // 2022.08.16

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

//	아직 글을 모르는 의석이가 벽에 걸린 칠판에 자석이 붙어있는 글자들을 붙이는 장난감을 가지고 놀고 있다.
//	이 장난감에 있는 글자들은 영어 대문자 ‘A’부터 ‘Z’, 영어 소문자 ‘a’부터 ‘z’, 숫자 ‘0’부터 ‘9’이다. 의석이는 칠판에 글자들을 수평으로 일렬로 붙여서 단어를 만든다.
//	다시 그 아래쪽에 글자들을 붙여서 또 다른 단어를 만든다. 이런 식으로 다섯 개의 단어를 만든다. 아래에 의석이가 칠판에 붙여 만든 단어들의 예가 있다.
//
//	A A B C D D
//	a f z z
//	0 9 1 2 1
//	a 8 E W g 6
//	P 5 h 3 k x
//
//	만들어진 다섯 개의 단어들의 글자 개수는 서로 다를 수 있다.
//	 
//	심심해진 의석이는 칠판에 만들어진 다섯 개의 단어를 세로로 읽으려 한다.
//	세로로 읽을 때, 각 단어의 첫 번째 글자들을 위에서 아래로 세로로 읽는다. 다음에 두 번째 글자들을 세로로 읽는다.
//	이런 식으로 왼쪽에서 오른쪽으로 한 자리씩 이동 하면서 동일한 자리의 글자들을 세로로 읽어 나간다.
//	위의 그림 1의 다섯 번째 자리를 보면 두 번째 줄의 다섯 번째 자리의 글자는 없다. 이런 경우처럼 세로로 읽을 때 해당 자리의 글자가 없으면, 읽지 않고 그 다음 글자를 계속 읽는다.
//	그림 1의 다섯 번째 자리를 세로로 읽으면 D1gk로 읽는다.
//	위에서 의석이가 세로로 읽은 순서대로 글자들을 공백 없이 출력하면 다음과 같다:
//
//	Aa0aPAf985Bz1EhCz2W3D1gkD6x
//
//	칠판에 붙여진 단어들이 주어질 때, 의석이가 세로로 읽은 순서대로 글자들을 출력하는 프로그램을 작성하라.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스의 수 T를 받아 tc는 1부터 T까지 for문을 돌도록 하자.
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#" + tc + " ");

			// 각 테스트 케이스마다 1이상 15이하의 문자열이 5개씩 주어지므로 [5][15]크기의 2차원 배열을 만들어 입력값을 저장해준다.
			String wordBoard[][] = new String[5][15];
			for (int i = 0; i < 5; i++) {
				String temp = br.readLine();
				String arr[] = temp.split("");
				for (int j = 0; j < arr.length; j++) {
					wordBoard[i][j] = arr[j];
				}
			}
			
			// 세로로 야무지게 출력만 해주면 끝!
			for (int k = 0; k < 15; k++) {
				for (int l = 0; l < 5; l++) {
					if (wordBoard[l][k] != null) {
						System.out.print(wordBoard[l][k]);
					}
				}
			}
			System.out.println("");
		}

	} // main
} // class
