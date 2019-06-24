package org.abhi.beans;

import java.util.function.Consumer;

public class StringPrinter {
	public static void print(String s) {
		System.out.println(s);
	}
	
	public static void print(MyClass s) {
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		System.out.println(System.out instanceof Consumer);
	}
}
