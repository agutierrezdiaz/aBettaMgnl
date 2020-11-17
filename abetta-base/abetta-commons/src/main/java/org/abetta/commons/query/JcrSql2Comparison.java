package org.abetta.commons.query;

public class JcrSql2Comparison implements JcrSql2Condition {

	private String property;
	private ComparisonOperators operator;
	private String value;

	public JcrSql2Comparison(String property, ComparisonOperators operator, String value) {
		this.property = property == null ? "" : property;
		this.operator = operator;
		this.value = value;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public ComparisonOperators getOperator() {
		return operator;
	}

	public void setOperator(ComparisonOperators operator) {
		this.operator = operator;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String getQuery() {
		return String.format(this.operator.getQuery().replace("%property%", this.property), this.value);
	}

}
