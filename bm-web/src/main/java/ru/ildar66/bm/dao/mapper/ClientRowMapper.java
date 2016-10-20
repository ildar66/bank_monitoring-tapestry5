package ru.ildar66.bm.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.ildar66.bm.common.entity.Client;
import ru.ildar66.bm.dao.util.AbstractRowMapper;

/**
 * RowMapper for {@link Client}
 * 
 * @author Shafigullin Ildar
 * 
 */
public class ClientRowMapper extends AbstractRowMapper<Client> {

	public static final ClientRowMapper INSTANCE = new ClientRowMapper();

	// @Override
	public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
		Client object = new Client(getString(rs, "client_name"));
		object.setId(getString(rs, "client_id"));
		return object;
	}
}
