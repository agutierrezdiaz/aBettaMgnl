package org.abetta.commons.query;

import java.util.ArrayList;
import java.util.Collection;

public class JcrSql2Subcondition implements JcrSql2Condition {

	private Collection<JcrSql2Condition> subConditions;

	public JcrSql2Subcondition() {
		this.subConditions = new ArrayList<>();
	}

	public JcrSql2Subcondition(Collection<JcrSql2Condition> subConditions) {
		this.subConditions = subConditions;
	}

	public Collection<JcrSql2Condition> getSubConditions() {
		return subConditions;
	}

	public void setSubConditions(Collection<JcrSql2Condition> subConditions) {
		this.subConditions = subConditions;
	}
	
	public void addCondition(JcrSql2Condition condition) {
		this.subConditions.add(condition);
	}

	@Override
	public String getQuery() {
		String result = "";
		if (null != this.subConditions) {
			result = result.concat(" (");
			for (JcrSql2Condition c : this.subConditions) {
				result = result.concat(c.getQuery());
			}
			result = result.concat(") ");
		}

		return result;
	}

	public static class Builder {

		private JcrSql2Subcondition subcondition;

		public Builder() {
			subcondition = new JcrSql2Subcondition();
		}
		
		public Builder addCondition(JcrSql2Condition condition) {
			subcondition.addCondition(condition);
			return this;
		}
		
		public Builder addSubCondition(JcrSql2Subcondition condition) {
			subcondition.addCondition(condition);
			return this;
		}
		
		public Builder and() {
			subcondition.addCondition(JcrSql2ConditionConnector.AND);
			return this;
		}
		
		public Builder or() {
			subcondition.addCondition(JcrSql2ConditionConnector.OR);
			return this;
		}
		
		public Builder orNot() {
			subcondition.addCondition(JcrSql2ConditionConnector.OR_NOT);
			return this;
		}
		
		public JcrSql2Subcondition build() {
			return subcondition;
		}
		
	}

}
