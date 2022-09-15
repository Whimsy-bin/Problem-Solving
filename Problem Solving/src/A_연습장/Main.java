package A_연습장;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws IOException {

//		Stream<Integer> num = Stream.of(1, 2, 3, 4);
//		Optional<Integer> plus = num.reduce((a, b) -> a + b);
//		System.out.println(plus.orElse(1111));
//
//		int factorial = IntStream.range(2, 10).reduce(1, (a, b) -> a * b);
//		System.out.println(factorial);
		float a = 0.1f;
		float b = 1.1f;
		System.out.println(a + b == 1.2);

	} // main
} // class
