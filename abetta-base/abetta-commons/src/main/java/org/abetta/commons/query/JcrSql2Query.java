package org.abetta.commons.query;

import java.util.ArrayList;
import java.util.Collection;

import org.abetta.commons.query.constants.JcrQueryConstants;

public class JcrSql2Query {

	private Collection<JcrSql2QueryPart> queryParts;

	public JcrSql2Query() {
		super();
	}

	public JcrSql2Query(Collection<JcrSql2QueryPart> queryParts) {
		this.queryParts = queryParts;
	}

	public Collection<JcrSql2QueryPart> getQueryParts() {
		return queryParts;
	}

	public void setQueryParts(Collection<JcrSql2QueryPart> queryParts) {
		this.queryParts = queryParts;
	}

	public void addQueryPart(JcrSql2QueryPart... parts) {
		if (this.queryParts == null) {
			this.queryParts = new ArrayList<>();
		}

		if (null != parts) {
			for (JcrSql2QueryPart part : parts) {
				if (part != null) {
					this.queryParts.add(part);
				}
			}
		}
	}

	@Override
	public String toString() {
		String result = "";
		if (this.queryParts != null) {
			for (JcrSql2QueryPart part : this.queryParts) {
				result = result.concat(part.getQuery());
			}
		} else {
			result = "JCR-SQL2 Query not setting";
		}
		return result;
	}

	public static class Builder {

		private JcrSql2Query query;

		private Select select;
		private From from;
		private Where where;
		private Order order;

		public Builder() {
			query = new JcrSql2Query();
			select = new Select();
			from = new From();
		}

		public Builder addContentType(String contentType, String alias) {
			from = new From(contentType, alias);
			return this;
		}

		public Builder where(Where conditions) {
			where = conditions;
			return this;
		}

		public Builder sortAscending(String property) {
			return sortAscending(property, null);
		}

		public Builder sortAscending(String property, String alias) {
			if (order == null) {
				order = new Order();
			}
			order.addSortRule(addPrefix(alias, property), JcrQueryConstants.ASC);
			return this;
		}

		public Builder sortDescending(String property) {
			return sortDescending(property, null);
		}

		public Builder sortDescending(String property, String alias) {
			if (order == null) {
				order = new Order();
			}
			order.addSortRule(addPrefix(alias, property), JcrQueryConstants.DESC);
			return this;
		}

		private String addPrefix(String alias, String property) {
			if (alias != null && !alias.isEmpty()) {
				return String.format("%s.", alias).concat(property);
			} else {
				return property;
			}
		}

		public JcrSql2Query build() {
			query.addQueryPart(select, from, where, order);
			return query;
		}

	}

}
