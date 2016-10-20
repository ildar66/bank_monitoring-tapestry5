package ru.ildar66.bm.dao.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import ru.ildar66.bm.common.entity.Currency;
import ru.ildar66.bm.common.entity.DealType;

/**
 * abstract super class for spring RowMapper support.
 * 
 * @author Shafigullin Ildar
 * 
 */
public abstract class AbstractRowMapper<T> implements RowMapper<T> {
	// mapping for primitive types:
	protected String getString(ResultSet rs, String columnLabel) throws SQLException {
		return rs.getString(columnLabel);
	}

	protected Integer getInteger(ResultSet rs, String columnLabel) throws SQLException {
		Integer value = rs.getInt(columnLabel);
		return rs.wasNull() ? null : value;
	}

	protected Long getLong(ResultSet rs, String columnLabel) throws SQLException {
		Long value = rs.getLong(columnLabel);
		return rs.wasNull() ? null : value;
	}

	protected Date getDate(ResultSet rs, String columnLabel) throws SQLException {
		return rs.getTimestamp(columnLabel);
	}

	protected Boolean getBoolean(ResultSet rs, String columnLabel) throws SQLException {
		String value = rs.getString(columnLabel);
		return YesNoUtil.asBoolean(value);
	}

	// mapping for enumeration types:
	protected DealType getDealType(ResultSet rs, String columnLabel) throws SQLException {
		String value = rs.getString(columnLabel);
		return value == null ? null : DealType.valueOf(value);
	}

	protected Currency getCurrency(ResultSet rs, String columnLabel) throws SQLException {
		String value = rs.getString(columnLabel);
		return value == null ? null : Currency.valueOf(value);
	}
}
