package org.abhi.beans;

public interface Movable {
	default String move(String place) {
		return "Moved to " + place;
	}
}
