package org.abhi.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Z001TestStreams004 {
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
		
		boolean result = memberNames.stream().anyMatch((s) -> s.startsWith("A") || s.startsWith("a"));
		System.out.println(result);
		result = memberNames.stream().allMatch((s) -> s.startsWith("A") || s.startsWith("a"));
		System.out.println(result);
		result = memberNames.stream().noneMatch((s) -> s.startsWith("A") || s.startsWith("a"));
		System.out.println(result);
		result = memberNames.stream().noneMatch((s) -> s.startsWith("Z") || s.startsWith("z"));
		System.out.println(result);
		System.out.println("S list = " + memberNames.stream().filter((s) -> s.startsWith("S")).collect(Collectors.toList()).toString());
		System.out.println("S count = " + memberNames.stream().filter((s) -> s.startsWith("S")).count());
	
		Optional<String> reduced = memberNames.stream().reduce((s1, s2)->s1+"##"+s2);
		System.out.println(reduced.get());
	}
}
