package org.abhi.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.abhi.beans.MyClass;

public class Z001TestStreams006 {
	public static void main(String[] args) {
		List<MyClass> list = new ArrayList<>();
		list.add(new MyClass(3, "Three"));
		list.add(new MyClass(4, "Four"));
		//list.add(null);
		list.add(new MyClass(5, "Five"));
		list.add(new MyClass(1, "One"));
		list.add(new MyClass(1, "aaa"));
		list.add(new MyClass(4, null));
		
		
		List<MyClass> resultClasses = list.parallelStream().distinct().collect(Collectors.toList());
		resultClasses.forEach(System.out::println);
		System.out.println("-----------------------");
		list.parallelStream().sorted((obj1, obj2) -> obj1.getIntProperty().compareTo(obj2.getIntProperty())).collect(Collectors.toList()).forEach(System.out::println);;
		System.out.println("-----------------------");
		list.parallelStream().distinct().sorted((obj1, obj2) -> obj1.getIntProperty().compareTo(obj2.getIntProperty())).collect(Collectors.toList()).forEach(System.out::println);;
		
	}
}
