package org.abhi.test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.abhi.beans.MyClass;

public class TestLambda1 {
	public static void main(String[] args) {
		System.out.println("Hellp");
		MyOperations myOperation1 = (a, b) -> a * b;
		System.out.println(myOperation1.operation(5, 10));
		
		List<MyClass> list = new ArrayList<>();
		list.add(new MyClass(1, "One"));
		list.add(new MyClass(2, "aaa"));
		list.add(new MyClass(4, null));
		list.add(new MyClass(3, "Three"));
		list.add(new MyClass(4, "Four"));
		list.add(null);
		list.add(new MyClass(5, "Five"));
		
		System.out.println(list);
		Collections.sort(list, Comparator.nullsFirst(Comparator.comparing(MyClass::getIntProperty, Comparator.reverseOrder()).thenComparing(Comparator.comparing(MyClass::getStringProperty, Comparator.nullsFirst(Comparator.naturalOrder())))));
		/*
		 * Comparator<String> comparator = new Comparator<String>() {
		 * 
		 * @Override public int compare(String o1, String o2) { // TODO Auto-generated
		 * method stub return 0; } };
		 */
		System.out.println(list);
	}

	@FunctionalInterface
	public interface MyOperations {
		public int operation(int a, int b);
	}
}
