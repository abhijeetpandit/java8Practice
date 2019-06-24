package org.abhi.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.abhi.beans.MyClass;

public class Z001TestForeach001 {
	public static void main(String[] args) {
		List<MyClass> list = new ArrayList<>();
		list.add(new MyClass(1, "One"));
		list.add(new MyClass(2, "aaa"));
		list.add(new MyClass(4, null));
		list.add(new MyClass(3, "Three"));
		list.add(new MyClass(4, "Four"));
		//list.add(null);
		list.add(new MyClass(5, "Five"));
		
		Consumer<MyClass> consumer = new Consumer<MyClass>() {

			@Override
			public void accept(MyClass t) {
				System.out.println(t.getStringProperty());
			}
		};
		
		list.forEach(consumer);
		
		
	}
	
	
}
