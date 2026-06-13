package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Document;

public class DocumentMapper implements RowMapper<Document> {

	/**
	 * @param ResultSet,Rows return Document model
	 */
	@Override
	public Document mapRow(ResultSet rs, int rowNum) throws SQLException {
		Document model = new Document();
		model.setId(rs.getBigDecimal("id").toBigInteger());
		model.setName(rs.getString("name"));
		return model;
	}

}