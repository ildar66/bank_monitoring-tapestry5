package ru.ildar66.bm.dao;

import java.util.ArrayList;
import java.util.List;

import ru.ildar66.bm.common.entity.NotificationRecipient;
import ru.ildar66.bm.common.instance.DealEvent;
import ru.ildar66.bm.common.searchfilter.EventsByDealFilter;
import ru.ildar66.bm.common.util.SortCriterion;
import ru.ildar66.bm.dao.mapper.DealEventRowMapper;
import ru.ildar66.bm.dao.util.AbstractDao;

/**
 * DAO implementation for instance Deal.
 * 
 * @author Shafigullin Ildar
 */
public class DealDaoImpl extends AbstractDao implements DealDao {

	public List<DealEvent> getDealEvents(int startIndex, int amount, EventsByDealFilter filter,
			List<SortCriterion> sortCriteria) {
		ArrayList<Object> params = new ArrayList<Object>();
		String query = "select v.* from (";
		query += sql.get("EVENT_INSTANCES_SELECT");
		query += ", row_number() over (order by " + getOrderBy(sortCriteria) + ") rn ";
		query += sql.get("EVENT_INSTANCES_FROM");
		query = filterQuery(filter, query, params);
		query += " ) v where v.rn > ? and v.rn <= ? ";
		params.add(startIndex);
		params.add(startIndex + amount);
		return getJdbcTemplate().query(query, params.toArray(), DealEventRowMapper.INSTANCE);
	}

	private String getOrderBy(List<SortCriterion> sortCriteria) {
		String orderBy = "e.id";
		if (!sortCriteria.isEmpty()) {
			SortCriterion sortCriterion = sortCriteria.get(0);
			String propertyName = sortCriterion.getPropertyName();
			if ("amount".equalsIgnoreCase(propertyName)) {
				orderBy = "d.sum";
			} else if ("currency".equalsIgnoreCase(propertyName)) {
				orderBy = "d.currency";
			} else if ("other field".equalsIgnoreCase(propertyName)) {
				// TODO
			}
			orderBy += sortCriterion.getSortDirection().toStringForJpql();
		}
		return orderBy;

	}

	private String filterQuery(EventsByDealFilter filter, String query, List<Object> params) {
		if (filter.getCurrency() != null) {
			query += " AND d.currency = ? ";
			params.add(filter.getCurrency());
		}
		if (filter.getAmountFrom() != null) {
			query += " AND d.sum >= " + filter.getAmountFrom();
		}
		if (filter.getAmountTo() != null) {
			query += " AND d.sum <= " + filter.getAmountTo();
		}
		if (filter.getDateFrom() != null) {
			query += " AND d.valid_to >= ? ";
			params.add(new java.sql.Date(filter.getDateFrom().getTime()));
		}
		if (filter.getDateTo() != null) {
			query += " AND d.valid_to <= ? ";
			params.add(new java.sql.Date(filter.getDateTo().getTime()));
		}
		// TODO for another fields:
		return query;
	}

	public int getDealEventCount(EventsByDealFilter filter) {
		String query = sql.get("EVENT_INSTANCE_COUNT");
		List<Object> params = new ArrayList<Object>();
		query = filterQuery(filter, query, params);
		return getJdbcTemplate().queryForInt(query, params.toArray());
	}

	public void persist(DealEvent event) {
		// TODO Auto-generated method stub

	}

	public DealEvent getDealEventById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public NotificationRecipient getNotificationRecipientById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
