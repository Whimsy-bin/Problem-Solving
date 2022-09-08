package A_연습장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//import com.google.common.base.Splitter;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 케이스의 수 T를 받아서 tc=1부터 T까지 for문을 돌도록 해요
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			
			// 출력하면서 한 회차 끝!
			System.out.println("#" + tc + " ");
		}
		
		br.close();

		String str = br.readLine();
		String[] card = str.split("(?<=\\G...)");
//		Iterable<String> piece = Splitter.fixedLength(3).split(str);
		
		System.out.println(Arrays.toString(card));
		
		
		System.out.println(1.1+0.1==1.2);
		
	} // main
} // class
