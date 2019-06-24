package org.abhi.test;

import java.util.HashMap;

import org.abhi.beans.Printer;

public class Z001TestForeach002 {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();

		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		map.put(null, 4);
		map.put("E", null);

		map.forEach((key, value) -> System.out.println(key + "->" + value));

		System.out.println("------------------------------");
		map.entrySet().forEach((entry) -> {
			String key = entry.getKey() == null ? "\"\"" : entry.getKey();
			Integer value = entry.getValue() == null ? 0 : entry.getValue();
			System.out.println(key + "->" + value);
		});
		
		System.out.println("------------------------------");
		map.entrySet().forEach((entry) -> Printer.print(entry));
		
	}
}
