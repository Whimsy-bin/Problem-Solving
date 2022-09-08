package SWEA_1216_회문2; // 2022.08.12~13 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) throws IOException {

//		"기러기" 또는 "level" 과 같이 거꾸로 읽어도 앞에서부터 읽은 것과 같은 문장이나 낱말을 회문(回文, palindrome)이라 한다.
//		주어진 100x100 평면 글자판에서 가로, 세로를 모두 보아 가장 긴 회문의 길이를 구하는 문제이다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스는 10개이므로 10번만 while문을 돌도록 한다.
		int T = 10;
		int tc = 1;
		while (tc <= T) {
			int N = Integer.parseInt(br.readLine());

			// 100X100 크기의 단어판에 글자 입력 저장
			int size = 100;
			String wordBoard[][] = new String[size][size];
			for (int i = 0; i < size; i++) {
				String s = br.readLine();
				String arr[] = s.split("");
				for (int j = 0; j < size; j++) {
					wordBoard[i][j] = arr[j];
				}
			}

			int max = 101;
			boolean check = true;
			do {
				List<String> str = new ArrayList<>(); // 똑바로 읽으면서 단어를 저장할 배열
				List<String> rev = new ArrayList<>(); // 거꾸로 읽으면서 철자를 저장할 배열
				max--;

				// 목표 : (X,Y) 좌표에서 똑바로 단어와 거꾸로 단어를 배열에 저장하고 둘이 일치하는지 여부를 확인한다.
				int Y = 0;
				do {
					int X = 0;
					do {
						// X축 방향으로 똑바로 단어와 거꾸로 단어를 살펴보기
						if (X <= size - max) {
							for (int k = 0; k < max; k++) {
								str.add(wordBoard[Y][X + k]); // 얘는 똑바로 철자를 불러와 저장하고
								rev.add(wordBoard[Y][X + max - 1 - k]); // 얘는 거꾸로 철자를 불러와 저장한다.
							}

							// 둘이 일치하면 check를 false로 바꾸어주고 더 이상 확인할 필요가 없으니 탈출한다.
							if (str.equals(rev))
								check = false;

							// 또 써야 하니까 사용한 str배열과 rev배열은 비워준다.
							str.clear();
							rev.clear();
						}
						// X축 방향으로 탐색했을 때 없었다면 Y축 방향으로도 같은 방식으로 살펴본다.
						if (check && Y <= size - max) {
							for (int l = 0; l < max; l++) {
								str.add(wordBoard[Y + l][X]);
								rev.add(wordBoard[Y + max - 1 - l][X]);
							}

							if (str.equals(rev))
								check = false;

							str.clear();
							rev.clear();
						}
						X++;
					} while (check && X < size);
					Y++;
				} while (check && Y < size);
			} while (check);

			// 알맞은 형식에 맞추어 출력을 해주고 한 회차를 마쳤으니 tc++을 해줄게요~
			System.out.println("#" + N + " " + max);
			tc++;

		}
		br.close();

	} // main
} // class