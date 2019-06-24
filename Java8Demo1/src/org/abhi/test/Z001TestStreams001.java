package org.abhi.test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Z001TestStreams001 {
	public static void main(String[] args) {
		Stream<Number> integers = Stream.of(new Number[] {1,2,4,5.34343});
		integers.forEach((i) -> System.out.println(i));
		
		System.out.println("-------------------");
		IntStream intStream = "124433FDF$dfd".chars();
		intStream.forEach(c -> System.out.println((char)c));
		
		System.out.println("-------------------");
		
		Stream<Integer> numberStream = Stream.of(new Integer[] {1,2,4,5});
		Object[] filteredNumberstream = numberStream.filter((num) -> (num%2) == 0).toArray();
		Stream.of(filteredNumberstream).forEach(System.out::println);
		
		
	}
}
