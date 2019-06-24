package org.abhi.beans;
public class MyClass {
	private Integer intProperty = 0;
	private String stringProperty = null;

	public MyClass(int intProperty, String stringProperty) {
		super();
		this.intProperty = intProperty;
		this.stringProperty = stringProperty;
	}

	public Integer getIntProperty() {
		return intProperty;
	}

	public void setIntProperty(Integer intProperty) {
		this.intProperty = intProperty;
	}

	public String getStringProperty() {
		return stringProperty;
	}

	public void setStringProperty(String stringProperty) {
		this.stringProperty = stringProperty;
	}

	@Override
	public String toString() {
		return "MyClass [intProperty=" + intProperty + ", stringProperty=" + stringProperty + "]";
	}

}