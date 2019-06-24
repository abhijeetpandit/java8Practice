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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((intProperty == null) ? 0 : intProperty.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyClass other = (MyClass) obj;
		if (intProperty == null) {
			if (other.intProperty != null)
				return false;
		} else if (!intProperty.equals(other.intProperty))
			return false;
		return true;
	}

}