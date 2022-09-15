package boj_1244_스위치켜고끄기; // 2022.08.24

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

//	1부터 연속적으로 번호가 붙어있는 스위치들이 있다. 스위치는 켜져 있거나 꺼져있는 상태이다.
//	그리고 학생 몇 명을 뽑아서, 학생들에게 1 이상이고 스위치 개수 이하인 자연수를 하나씩 나누어주었다.
//	학생들은 자신의 성별과 받은 수에 따라 아래와 같은 방식으로 스위치를 조작하게 된다.
//
//	남학생은 스위치 번호가 자기가 받은 수의 배수이면, 그 스위치의 상태를 바꾼다. 즉, 스위치가 켜져 있으면 끄고, 꺼져 있으면 켠다.
//
//	여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서, 그 구간에 속한 스위치의 상태를 모두 바꾼다.
//	이때 구간에 속한 스위치 개수는 항상 홀수가 된다.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 스위치의 갯수
		List<Integer> Switch = new ArrayList<>(); // 스위치의 상태 정보를 저장할 배열 선언
		Switch.add(-1); // 배열 활용의 편의성을 위해 0번 index에는 값을 -1을 저장해주자.

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			Switch.add(Integer.parseInt(st.nextToken()));

		int S = Integer.parseInt(br.readLine()); // 학생의 수
		// 목표 : 스위치를 이래저래 조작해보자!
		for (int j = 0; j < S; j++) {
			st = new StringTokenizer(br.readLine());
			String gender = st.nextToken(); // 학생의 성별
			int num = Integer.parseInt(st.nextToken()); // 학생이 받은 수

			// 남학생이라면
			if (gender.equals("1")) {
				for (int k = 1; k <= N; k++) {
					if (k % num == 0)
						Switch.set(k, 1 - Switch.get(k));
				}
			}

			// 여학생이라면
			else {
				// 스위치의 상태를 바꿔줄 범위의 양쪽 끝을 찾자.
				int start = num;
				int last = num;
				while (1 < start && last < N) { // 양쪽 끝이 스위치의 범위 안에 있다면 while문을 돈다.
					if (Switch.get(start - 1) == Switch.get(last + 1)) {
						start--;
						last++;
					} // 끝이 같지 않게 되면 바로 while문 탈출
					else
						break;
				}

				// 이제 구한 범위에서 스위치의 상태를 모두 바꾸어주자.
				for (int l = start; l <= last; l++)
					Switch.set(l, 1 - Switch.get(l));

			}
		} // 목표 for문이 끝나는 곳

		// 이제 바꿔진 스위치 상태의 정보를 sb에 저장해주면 끝!
		for (int m = 1; m <= N; m++)
			sb.append(Switch.get(m)).append(m % 20 == 0 ? "\n" : " ");
		System.out.println(sb);
		br.close();

	} // main
} // class
