package functionalprogramming.chapter3;

import java.util.function.Function;

import functionalprogramming.chapter3.util.Adder;

public class Chapter3Section1 {
	public static void main(String[] args) {
		Function<Integer, Integer> myAdder = new Adder();
		int result = myAdder.apply(5);
		System.out.println(result);
	}
}
