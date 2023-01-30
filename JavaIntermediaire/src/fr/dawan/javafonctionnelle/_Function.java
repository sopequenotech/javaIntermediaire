package fr.dawan.javafonctionnelle;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
	
	public static void main(String[] args) {
		
		int result = incrementByOne(5);
		System.out.println(result);
		
		int r = incrementByOneFunction.apply(5);
		System.out.println(r);
		
		Function<Integer, Integer> incrementAndThenMultiplyByTen = incrementByOneFunction.andThen(multiplyByTen);
		System.out.println(incrementAndThenMultiplyByTen.apply(10)); //110
		
		System.out.println(incrementByOneAndMultiplyBiFunction.apply(5,6)); //36
		
		
	}
	
	static int incrementByOne(int x) {
		return x + 1;
	}
	
	static Function<Integer, Integer> incrementByOneFunction = x -> x + 1;
	static Function<Integer, Integer> multiplyByTen = x -> x * 10;
	static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction = 
			(numberToIncrement, numberToMultiply) -> (numberToIncrement+1) * numberToMultiply;

}
