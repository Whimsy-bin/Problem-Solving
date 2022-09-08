package SWEA_1231_중위순회; // 2022.08.23

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

//	다음은 특정 단어(또는 문장)를 트리 형태로 구성한 것으로, in-order 형식으로 순회하여 각 노드를 읽으면 원래 단어를 알 수 있다고 한다.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 테스트 케이스 수는 10개가 주어지므로 tc=1부터 10까지 for문을 돌도록 하자.
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			int N = Integer.parseInt(br.readLine()); // 이번 회차에서 정점의 갯수
			String[][] tree = new String[N + 1][3]; // 정점의 정보를 담을 tree 가변배열 선언(0번 행은 사용하지 않을 것이다)

			// 정점의 정보에 따라 열의 길이를 설정해주면서 tree의 정보 입력값을 받아주자.
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken()); // (i와 같은 값이다)
				for (int j = 0; st.hasMoreTokens(); j++)
					tree[idx][j] = st.nextToken();
			}

			// N보다 작은 2의 제곱수를 찾기 위해 HashSet을 써주자.
			HashSet<Integer> square = new HashSet<>();
			square.add(1);
			square.add(2);
			square.add(4);
			square.add(8);
			square.add(16);
			square.add(32);
			square.add(64);

			int idx = N;
			while (!square.contains(idx))
				idx--;
			int last = idx - 1; // 마지막으로 출력될 정점 번호는 처음 출력될 정점 번호보다 하나 작은 수이다.

			// 목표 : 중위순회 방식으로 올바른 단어를 찾아보자!
			while (true) {
				// 왼쪽 자식이 있다면 왼쪽 자식 쪽으로 가자!
				if (tree[idx][1] != null)
					idx = Integer.parseInt(tree[idx][1]);
				// 왼쪽 자식이 없는데 오른쪽 자식이 있다면 오른쪽 자식으로 가자!
				else if (tree[idx][2] != null) {
					sb.append(tree[idx][0]);
					tree[idx][0] = null;
					idx = Integer.parseInt(tree[idx][2]);
					tree[idx / 2][2] = null;
				} 
				// 양쪽 자식 다 없다면 출력하고 부모로 가자!
				else {
					if (tree[idx][0] != null)
						sb.append(tree[idx][0]);
					tree[idx][0] = null;
					if (idx == last)
						break;
					idx /= 2;
					tree[idx][1] = null;
				}
			} // 목표 while문이 닫히는 곳
			
			// 한 회차를 마치면서 줄바꿈을 해주자.
			sb.append("\n");
		}

		System.out.println(sb);
		br.close();

	} // main
} // class
