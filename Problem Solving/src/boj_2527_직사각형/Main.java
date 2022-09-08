package boj_2527_직사각형; // 2022.08.19

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x_Fir = Integer.parseInt(st.nextToken());
		int y_Fir = Integer.parseInt(st.nextToken());
		int p_Fir = Integer.parseInt(st.nextToken());
		int q_Fir = Integer.parseInt(st.nextToken());

		int x_Sec = Integer.parseInt(st.nextToken());
		int y_Sec = Integer.parseInt(st.nextToken());
		int p_Sec = Integer.parseInt(st.nextToken());
		int q_Sec = Integer.parseInt(st.nextToken());

		String ans = "a";

		if (p_Fir < x_Sec || q_Fir < y_Sec || p_Sec < x_Fir || q_Sec < y_Fir)
			ans = "d";
		
		else if (x_Sec == p_Fir) {
			
			ans = "b";
			if (y_Sec == q_Fir || q_Sec == y_Fir)
				ans = "c";
						
		} else if (y_Sec == q_Fir) {
			
			ans = "b";
			if (x_Sec == p_Fir || p_Sec == x_Fir)
				ans = "c";
			
		} else if (p_Sec == x_Fir) {
			
			ans = "b";
			if (q_Sec == y_Fir || y_Sec == q_Fir)
				ans = "c";
			
		} else if (q_Sec == y_Fir) {
			
			ans = "b";
			if (p_Sec == x_Fir || x_Sec == p_Fir)
				ans = "c";
			
		}

		System.out.println(ans);

	} // main
} // class
