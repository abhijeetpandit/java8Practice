package org.abhi.test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Z002IntStreamBoxed {
	public static void main(String[] args) {
		List<Integer> boxedIntegersList = IntStream.of(1,2,3,4,5,6).boxed().collect(Collectors.toList());
		System.out.println(boxedIntegersList);
	}
}
