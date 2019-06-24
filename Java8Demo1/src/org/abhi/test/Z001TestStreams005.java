package org.abhi.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Z001TestStreams005 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i< 100; i++){
            list.add(i);
        }
        System.out.println("start");
        list.parallelStream().forEach(System.out::println);
        System.out.println("end");
        System.out.println("start");
        Integer[] ints  = list.parallelStream().filter((i) ->i%2==0).toArray(Integer[]::new);
        Stream.of(ints).forEach(System.out::println);
        System.out.println("end");
	}
}
