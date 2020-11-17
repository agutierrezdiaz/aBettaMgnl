package org.abetta.commons.query;

import org.abetta.commons.query.constants.JcrQueryConstants;
import org.abetta.commons.query.constants.MgnlTypesConstants;

public class From implements JcrSql2QueryPart {

	private String source;
	private String alias;

	public From() {
		this.source = MgnlTypesConstants.NT_BASE;
		this.alias = "c";
	}

	public From(String source, String alias) {
		this.source = source;
		this.alias = alias;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Override
	public String getQuery() {
		return JcrQueryConstants.FROM.concat(String.format(" [%s] ", this.source)).concat(JcrQueryConstants.ALIAS)
				.concat(String.format(" %s ", "c"));
	}

}
