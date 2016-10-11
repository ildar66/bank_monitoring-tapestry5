package ru.ildar66.bm.common.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.grid.SortConstraint;

/**
 * Converts a list of Tapestry's SortConstraint to a list of our business tier's SortCriterion.
 * The business tier does not use SortConstraint because that would create a dependency on Tapestry.
 */
public class SortUtil {
	public final static List<SortCriterion> toSortCriteria(List<SortConstraint> sortConstraints) {
		List<SortCriterion> sortCriteria = new ArrayList<SortCriterion>();

		for (SortConstraint sortConstraint : sortConstraints) {

			String propertyName = sortConstraint.getPropertyModel().getPropertyName();
			SortDirection sortDirection = SortDirection.UNSORTED;

			switch (sortConstraint.getColumnSort()) {
			case ASCENDING:
				sortDirection = SortDirection.ASCENDING;
				break;
			case DESCENDING:
				sortDirection = SortDirection.DESCENDING;
				break;
			default:
			}

			SortCriterion sortCriterion = new SortCriterion(propertyName, sortDirection);
			sortCriteria.add(sortCriterion);
		}

		return sortCriteria;
	}
}
