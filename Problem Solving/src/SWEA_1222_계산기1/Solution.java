package SWEA_1222_계산기1; // 2022.08.18~19

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

//	문자열로 이루어진 계산식이 주어질 때, 이 계산식을 후위 표기식으로 바꾸어 계산하는 프로그램을 작성하시오.
//
//	예를 들어
//	“3+4+5+6+7”
//	라는 문자열로 된 계산식을 후위 표기식으로 바꾸면 다음과 같다.
//	"34+5+6+7+"
//	변환된 식을 계산하면 25를 얻을 수 있다.
//
//	문자열 계산식을 구성하는 연산자는 + 하나뿐이며 피연산자인 숫자는 0 ~ 9의 정수만 주어진다.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		for(int tc = 1; tc <= T ; tc ++) {
			int length = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			Stack<String> formula = new Stack<>();
			for(int i = 0; i<length; i++) {
				String temp = st.nextToken();
				if(temp.equals("+"))
				formula.push(st.nextToken());	
			}
			
			
			
			System.out.println("#" + tc + " ");
		}
		
		br.close();

	} // main
} // class
