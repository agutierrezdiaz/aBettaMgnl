package org.abetta.commons.query;

import org.abetta.commons.query.constants.JcrQueryConstants;

public enum ComparisonOperators {

	EQUALS (JcrQueryConstants.COMPARATION_FORMAT, JcrQueryConstants.EQUALS),
	NOT_EQUALS (JcrQueryConstants.COMPARATION_FORMAT, JcrQueryConstants.NOT_EQUALS),
	GREATER_THAN (JcrQueryConstants.COMPARATION_FORMAT, JcrQueryConstants.GREATER_THAN),
	LESS_THAN (JcrQueryConstants.COMPARATION_FORMAT, JcrQueryConstants.LESS_THAN),
	GREATER_THAN_OR_EQUALS (JcrQueryConstants.COMPARATION_FORMAT, JcrQueryConstants.GREATER_THAN_OR_EQUALS),
	LESS_THAN_OR_EQUALS (JcrQueryConstants.COMPARATION_FORMAT, JcrQueryConstants.LESS_THAN_OR_EQUALS),
	CONTAINS (JcrQueryConstants.CONDITION_FORMAT, JcrQueryConstants.CONTAINS),
	ISDESCENDANTNODE (JcrQueryConstants.CONDITION_FORMAT, JcrQueryConstants.ISDESCENDANTNODE);
	
	private String query;
	private String value;

	private ComparisonOperators(String query, String value) {
		this.query = query;
		this.value = value;
	}

	public String getQuery() {
		return query.replace("%c", value);
	}

}
