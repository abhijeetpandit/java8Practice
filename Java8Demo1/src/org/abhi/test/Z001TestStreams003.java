package org.abhi.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Z001TestStreams003 {
	public static void main(String[] args) {
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Shekhar");
		memberNames.add("aman");
		memberNames.add("Rahul");
		memberNames.add("Shahrukh");
		memberNames.add("Salman");
		memberNames.add("Yana");
		memberNames.add("Lokesh");
		
		memberNames.stream().filter((s) -> s.startsWith("A") || s.startsWith("a")).forEach(System.out::println);
		System.out.println("---------------------------------");
		memberNames.stream().filter((s) -> s.startsWith("A") || s.startsWith("a")).map(String::toUpperCase).forEach(System.out::println);
		System.out.println("---------------------------------");
		memberNames.stream().sorted().forEach(System.out::println);
		System.out.println("---------------------------------");
		memberNames.stream().sorted().map(String::toUpperCase).forEach(System.out::println);
		System.out.println("---------------------------------");
		memberNames.stream().map(String::toUpperCase).sorted().forEach(System.out::println);
		System.out.println("---------------------------------");
		List<String> list = memberNames.stream().map(String::toUpperCase).sorted().collect(Collectors.toList());
		System.out.println(list);
	}
}
