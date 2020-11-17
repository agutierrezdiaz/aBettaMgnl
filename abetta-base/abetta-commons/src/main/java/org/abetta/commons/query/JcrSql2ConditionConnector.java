package org.abetta.commons.query;

import org.abetta.commons.query.constants.JcrQueryConstants;

public enum JcrSql2ConditionConnector implements JcrSql2Condition {

	AND (JcrQueryConstants.AND),
	OR (JcrQueryConstants.OR),
	OR_NOT (JcrQueryConstants.OR_NOT);

	private String query;
	
	private JcrSql2ConditionConnector(String query) {
		this.query = query;
	}

	@Override
	public String getQuery() {
		return this.query;
	}

}
