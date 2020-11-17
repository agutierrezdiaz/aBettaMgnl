package org.abetta.commons.query;

import org.abetta.commons.query.constants.JcrQueryConstants;

public class Select implements JcrSql2QueryPart {

	private String fields;

	public Select() {
		this.fields = "*";
	}

	public Select(String fields) {
		this.fields = fields;
	}

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	@Override
	public String getQuery() {
		return JcrQueryConstants.SELECT.concat(String.format(" %s ", this.fields));
	}

}
