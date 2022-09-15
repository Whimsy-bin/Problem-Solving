package boj_9093_단어뒤집기; // 2022.09.04

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

//	문장이 주어졌을 때, 단어를 모두 뒤집어서 출력하는 프로그램을 작성하시오.
//	단, 단어의 순서는 바꿀 수 없다. 단어는 영어 알파벳으로만 이루어져 있다.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				char[] target = st.nextToken().toCharArray();
				for (int j = target.length - 1; 0 <= j; j--)
					sb.append(target[j]);
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();

	} // main
} // class