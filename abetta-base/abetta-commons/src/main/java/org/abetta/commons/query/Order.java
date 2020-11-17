package org.abetta.commons.query;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.abetta.commons.query.constants.JcrQueryConstants;

public class Order implements JcrSql2QueryPart {

	private Map<String, String> rules;

	public Order() {
		this.rules = new HashMap<>();
	}

	public Order(Map<String, String> rules) {
		this.rules = rules;
	}

	public Map<String, String> getRules() {
		return rules;
	}

	public void setRules(Map<String, String> rules) {
		this.rules = rules;
	}

	public void addSortRule(String property, String direction) {
		rules.put(property, direction);
	}

	@Override
	public String getQuery() {
		String result = "";
		if (null != this.rules && this.rules.size() > 0) {
			result = JcrQueryConstants.ORDER_BY;
			Iterator<Entry<String, String>> it = rules.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, String> entry = it.next();
				result = result.concat(String.format(" %s ", entry.getKey())).concat(entry.getValue());
				if (it.hasNext()) {
					result = result.concat(", ");
				}
			}
		}

		return result;
	}

}
