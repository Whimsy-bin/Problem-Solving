package SWEA_1215_회문1; // 2022.08.12

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws IOException {

//		"기러기" 또는 "level" 과 같이 거꾸로 읽어도 앞에서부터 읽은 것과 같은 문장이나 낱말을 회문(回文, palindrome)이라 한다.
//		주어진 8x8 평면 글자판에서 가로, 세로를 모두 보아 제시된 길이를 가진 회문의 총 개수를 구하는 문제이다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;
		int tc = 1;
		while (tc <= T) { // 테스트 케이스의 번호 출력
			System.out.print("#" + tc + " ");
			
			int N = Integer.parseInt(br.readLine()); // 회문의 길이 입력
			
			// 8 X 8 크기의 단어판에 글자 입력 저장
			int size = 8; 
			String wordBoard[][] = new String[size][size];
			for (int i = 0; i < size; i++) {
				String s = br.readLine();
				String arr[] = s.split("");
				for (int j = 0; j < size; j++) {
					wordBoard[i][j] = arr[j];
				}
			}

			List<String> str = new ArrayList<>(); // 똑바로 읽으면서 단어를 저장할 배열
			List<String> rev = new ArrayList<>(); // 거꾸로 읽으면서 철자를 저장할 배열
			int palindrome = 0; // 회문의 갯수를 저장할 변수 선언
			
			// 목표 : 모든 점에서 똑바로 단어와 거꾸로 단어를 배열에 저장하고 둘이 일치하는지 여부를 확인하여 숫자를 구해준다.
			for (int Y = 0; Y < size; Y++) {
				for (int X = 0; X < size; X++) {

					// X축 방향으로 똑바로 단어와 거꾸로 단어를 살펴보기
					if (X <= size - N) {
						for (int k = 0; k < N; k++) {
							str.add(wordBoard[Y][X + k]); // 얘는 똑바로 철자를 불러와 저장하고
							rev.add(wordBoard[Y][X + N - 1 - k]); // 얘는 거꾸로 철자를 불러와 저장한다.
						}
						// 둘이 일치하면 palindrome++을 해준다.
						if (str.equals(rev))
							palindrome++;
						// 또 써야 하니까 사용한 str배열과 rev배열은 비워준다.
						str.clear();
						rev.clear();
					}
					// Y축 방향으로 똑바로 단어와 거꾸로 단어를 살펴보기(X축 방향과 방식은 동일)
					if (Y <= size - N) {
						for (int l = 0; l < N; l++) {
							str.add(wordBoard[Y + l][X]);
							rev.add(wordBoard[Y + N - 1 - l][X]);
						}
						if (str.equals(rev))
							palindrome++;
						str.clear();
						rev.clear();
					}

				}
			} // "목표" for문이 여기서 닫힌다
			
			// 출력을 해주고 한 회차를 마쳤으니 tc++을 해줄게요~
			System.out.println(palindrome);
			tc++;
		}

		br.close();
	} // main
} // class