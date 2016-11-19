package ru.ildar66.bm.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.ildar66.bm.common.instance.DealEvent;
import ru.ildar66.bm.dao.util.AbstractRowMapper;

/**
 * RowMapper for {@link DealEvent}
 * 
 * @author Shafigullin Ildar
 * 
 */
public class DealEventRowMapper extends AbstractRowMapper<DealEvent> {

	public static final DealEventRowMapper INSTANCE = new DealEventRowMapper();

	// @Override
	public DealEvent mapRow(ResultSet rs, int rowNum) throws SQLException {
		DealEvent object = new DealEvent();
		object.setName(getString(rs, "e_name"));
		object.setId(getLong(rs, "e_id"));
		object.setClient(ClientRowMapper.INSTANCE.mapRow(rs, rowNum));
		// object.setDeal(DealRowMapper.INSTANCE.mapRow(rs, rowNum));
		return object;
	}
}
