package ru.ildar66.bm.dao.util;

import java.util.Map;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * abstract super class for spring DAO support.
 * 
 * @author Shafigullin Ildar
 * 
 */
public abstract class AbstractDao {
	private JdbcTemplate jdbcTemplate = null;
	protected Map<String, String> sql;

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public DataSource getDataSource() {
		return jdbcTemplate.getDataSource();
	}

	protected JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setSql(Map<String, String> map) {
		this.sql = map;
	}
}
