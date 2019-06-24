package org.abhi.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.abhi.beans.MyClass;
import org.abhi.beans.StringPrinter;

public class Z001TestForeach003 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("One", "two", "three");
		
		list.forEach(StringPrinter::print);
		
		List<MyClass> list2 = new ArrayList<>();
		list2.add(new MyClass(1, "One"));
		list2.add(new MyClass(2, "aaa"));
		list2.add(new MyClass(4, null));
		list2.add(new MyClass(3, "Three"));
		list2.add(new MyClass(4, "Four"));
		list2.add(null);
		list2.add(new MyClass(5, "Five"));
		list2.forEach(StringPrinter::print);
		
		System.out.println("-----------------------------------");
		System.out.println("Filter nulls : ");
		
		Optional<MyClass> filteredObject = list2.stream().filter(myClass -> (myClass != null && myClass.getStringProperty() != null)).findFirst();
		
		List<MyClass> filteredList = list2.stream().filter(myClass -> (myClass != null && myClass.getStringProperty() != null)).collect(Collectors.toList());
		System.out.println("Filtered object = " + filteredObject.get());
		System.out.println("Filtered list = " + filteredList);
		
		System.out.println("----------------------------------------");
		
		list2.stream().filter(myClass -> (myClass != null && myClass.getStringProperty() != null)).forEach(System.out::println);
	}
}
