package ru.ildar66.bm.common.util;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SortCriterion implements Serializable {

	private String propertyName;
	private SortDirection sortDirection;

	public SortCriterion(String propertyName, SortDirection sortDirection) {
		this.propertyName = propertyName;
		this.sortDirection = sortDirection;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public SortDirection getSortDirection() {
		return sortDirection;
	}

}
