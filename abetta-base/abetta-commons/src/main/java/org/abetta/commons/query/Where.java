package org.abetta.commons.query;

import java.util.ArrayList;
import java.util.Collection;

import org.abetta.commons.query.constants.JcrQueryConstants;

public class Where implements JcrSql2QueryPart {

	private Collection<JcrSql2Condition> conditions;

	public Where() {
		this.conditions = new ArrayList<>();
	}

	public Where(Collection<JcrSql2Condition> conditions) {
		this.conditions = conditions;
	}

	public Collection<JcrSql2Condition> getConditions() {
		return conditions;
	}

	public void setConditions(Collection<JcrSql2Condition> conditions) {
		this.conditions = conditions;
	}
	
	public void addCondition(JcrSql2Condition condition) {
		this.conditions.add(condition);
	}

	@Override
	public String getQuery() {
		String result = "";
		if (null != this.conditions) {
			result = result.concat(JcrQueryConstants.WHERE);
			for (JcrSql2Condition c : this.conditions) {
				result = result.concat(c.getQuery());
			}
		}

		return result;
	}
	
	public static class Builder {
		
		private Where where;
		
		public Builder() {
			where = new Where();
		}
		
		public Builder addCondition(JcrSql2Comparison condition) {
			where.addCondition(condition);
			return this;
		}
		
		public Builder addSubCondition(JcrSql2Subcondition subcondition) {
			where.addCondition(subcondition);
			return this;
		}
		
		public Builder and() {
			where.addCondition(JcrSql2ConditionConnector.AND);
			return this;
		}
		
		public Builder or() {
			where.addCondition(JcrSql2ConditionConnector.OR);
			return this;
		}
		
		public Builder orNot() {
			where.addCondition(JcrSql2ConditionConnector.OR_NOT);
			return this;
		}
		
		public Where build() {
			return where;
		}
		
	}

}