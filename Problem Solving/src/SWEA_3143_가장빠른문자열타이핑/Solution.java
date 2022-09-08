package SWEA_3143_가장빠른문자열타이핑; // 2022.08.16

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

//	어떤 문자열 A를 타이핑하려고 한다.
//	그냥 한 글자씩 타이핑 한다면 A의 길이만큼 키를 눌러야 할 것이다.
//	여기에 속도를 조금 더 높이기 위해 어떤 문자열 B가 저장되어 있어서 키를 한번 누른 것으로 B전체를 타이핑 할 수 있다.
//	이미 타이핑 한 문자를 지우는 것은 불가능하다.
//
//	예를 들어 A=”asakusa”, B=”sa”일 때, B를 두 번 사용하면 5번 만에 A를 타이핑 할 수 있다.
//	A와 B가 주어질 때 A 전체를 타이핑 하기 위해 키를 눌러야 하는 횟수의 최솟값을 구하여라.

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 케이스 수 T를 받고 tc=1부터 T까지 for문을 돌도록 해요.
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();

			// 입력받은 A,B를 배열에 철자 하나씩 나누어 저장해요.
			String A[] = a.split("");
			String B[] = b.split("");
			
			int use = 0; // B의 사용횟수를 저장할 변수 선언
			// 목표 : A 문자열에 B가 몇 번 일치하는지 확인
			for (int i = 0; i <= A.length - B.length; i++) {
				int temp = 0;
				if (A[i].equals(B[0])) {
					temp++;
					for (int j = 1; j < b.length(); j++) {
						if (A[i + j].equals(B[j]))
							temp++;
						else
							break;
					}
				}
				// 일치할 때마다 use++을 해준다.
				if (temp == B.length)
					use++;
			}
			// B를 한 번 누를 때마다 아껴지는 타이핑 횟수는 (B의 문자길이 - 1)
			int ans = A.length - use * (B.length - 1);
			System.out.println("#" + tc + " " + ans);
		}

		br.close();
		
	} // main
} // class
