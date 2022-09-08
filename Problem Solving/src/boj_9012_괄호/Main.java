package boj_9012_괄호; // 2022.08.16

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

//	괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다.
//	그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다.
//	한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다.
//	만일 x 가 VPS 라면 이것을 하나의 괄호에 넣은 새로운 문자열 “(x)”도 VPS 가 된다.
//	그리고 두 VPS x 와 y를 접합(concatenation)시킨 새로운 문자열 xy도 VPS 가 된다.
//	예를 들어 “(())()”와 “((()))” 는 VPS 이지만 “(()(”, “(())()))” , 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다. 
//
//	여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다. 

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스의 수 T를 받고 tc가 1부터 T까지만 for문을 돌도록 하자.
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			String str = br.readLine();
			
			// 유효성 여부를 판단하여 저장할 ans 변수를 일단 YES로 저장하고 아래 과정에서 유효하지 않으면 NO로 바꿔주는 방식을 채용해보자.
			String ans = "YES";
			Stack<Character> stack = new Stack<>();
			
			// 목표 : 입력받은 문자열을 char형 배열에 저장하고 하나씩 확인해보자.
			for(char c : str.toCharArray()) {
				
				// 여는 괄호의 입력을 받으면, 여는 괄호를 추가해준다
				if(c == '(')
					stack.push(c);
				
				// 그렇지 않으면 닫는 괄호의 입력을 받은 것이다.
				else {
					// 스택이 비어 있으면, 짝을 이룰 여는 괄호가 없는 것이므로 ans = "NO"으로 바꿔주고 for문을 탈출한다.
					if(stack.isEmpty()){
						ans = "NO";
						break;
					}
					// 비어있지 않다면 짝지을 여는 괄호가 있는 것이므로, 해당 여는 괄호를 스택에서 빼준다.
					else
						stack.pop();
				}
			} //목표 for문이 닫히는 곳
			
			// 위의 과정이 끝났을 때 스택에 무언가 남아있다면, 짝을 이루지 못한 여는 괄호가 남은 것이므로 ans = "NO"로 바꿔준다.
			if (stack.isEmpty() == false)
				ans = "NO";
			
			// 계산한 값을 출력하면서 한 회차를 마친다.
			System.out.println(ans);
		}

		br.close();

	} // main
} // class