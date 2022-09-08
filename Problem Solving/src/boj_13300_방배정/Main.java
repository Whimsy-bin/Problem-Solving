package boj_13300_방배정; // 2022.08.21

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

//	정보 초등학교에서는 단체로 2박 3일 수학여행을 가기로 했다.
//	여러 학년이 같은 장소로 수학여행을 가려고 하는데 1학년부터 6학년까지 학생들이 묵을 방을 배정해야 한다.
//	남학생은 남학생끼리, 여학생은 여학생끼리 방을 배정해야 한다. 또한 한 방에는 같은 학년의 학생들을 배정해야 한다.
//	물론 한 방에 한 명만 배정하는 것도 가능하다.
//
//	한 방에 배정할 수 있는 최대 인원 수 K가 주어졌을 때, 조건에 맞게 모든 학생을 배정하기 위해 필요한 방의 최소 개수를 구하는 프로그램을 작성하시오.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] student = new int[6][2];
		int ans = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			student[y - 1][s]++;
		}

		for (int j = 0; j < 6; j++) {
			double girl = student[j][0];
			double boy = student[j][1];
			ans += Math.ceil(girl / K);
			ans += Math.ceil(boy / K);
		}

		System.out.println(ans);

	} // main
} // class
