package org.abhi.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Z001TestStreams007PickOperation {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        
		List<Integer> newList = list.stream()
		                            .peek(
		                            		(i)->System.out.print(i))
		                            .collect(
		                            		Collectors.toList());
		 
		System.out.println(newList);
	}
}
