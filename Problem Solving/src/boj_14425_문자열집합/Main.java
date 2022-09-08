package boj_14425_문자열집합; // 2022.08.16

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

//	총 N개의 문자열로 이루어진 집합 S가 주어진다.
//	입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는 것이 총 몇 개인지 구하는 프로그램을 작성하시오.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 집합 S에 포함되는 문자열들의 갯수
		int M = Integer.parseInt(st.nextToken()); // 검사해야 하는 문자열들의 갯수

		// 집합 S에 포함되는 문자열들을 동적 배열에 저장해봅시다.
		List<String> list = new ArrayList<>(); 
		for (int i = 0; i < N; i++) {
			list.add(br.readLine());
		}
		
		int ans = 0; // 답을 저장할 변수 선언
		// 목표 : 검사해야 하는 문자열들이 주어질 때마다 S가 저장된 배열에서 비교검색해서 일치하면 ans++을 해주자.
		for (int j = 0; j < M; j++) {
			String check = br.readLine();
			for (int k = 0; k < list.size(); k++) {
				if (list.get(k).equals(check)) {
					ans++;
					break;
				}
			}
		} // 목표 for문이 닫히는 곳

		System.out.println(ans);
		br.close();
		
	} // main
} // class
