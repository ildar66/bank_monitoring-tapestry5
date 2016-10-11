package ru.ildar66.bm.common.util;

public enum SortDirection {
	ASCENDING, DESCENDING, UNSORTED;

	public String toStringForJpql() {
		if (this == ASCENDING) {
			return "";
		} else if (this == DESCENDING) {
			return " desc";
		} else {
			return "";
		}
	}
}