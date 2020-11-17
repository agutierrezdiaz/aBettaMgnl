package org.abetta.commons;

import org.abetta.commons.query.ComparisonOperators;
import org.abetta.commons.query.JcrSql2Comparison;
import org.abetta.commons.query.JcrSql2Query;
import org.abetta.commons.query.Where;
import org.abetta.commons.query.constants.MgnlTypesConstants;

public class JcrQueryTest {

	public static void main(String[] args) {
//		JcrSql2Query query = new JcrSql2Query.Builder()
//				.addContentType(MgnlTypesConstants.CONTENTNODE_TYPE, "c")
//				.where(new Where.Builder()
//						.addCondition(new JcrSql2Comparison("name", ComparisonOperators.EQUALS, "manolo"))
//						.or()
//						.addCondition(new JcrSql2Comparison("name", ComparisonOperators.EQUALS, "jose"))
//						.and()
//						.addSubCondition(new JcrSql2Subcondition.Builder()
//								.addCondition(new JcrSql2Comparison("name", ComparisonOperators.EQUALS, "jose"))
//								.and()
//								.addSubCondition(new JcrSql2Subcondition.Builder()
//										.addCondition(new JcrSql2Comparison("name", ComparisonOperators.EQUALS, "jose"))
//										.or()
//										.addCondition(new JcrSql2Comparison("name", ComparisonOperators.EQUALS, "jose"))
//										.build())
//								.build())
//						.build())
//				.sortDescending("pepe", "c")
//				.sortAscending("manolo", "c")
//				.build();
		
		JcrSql2Query query = new JcrSql2Query.Builder()
				.addContentType(MgnlTypesConstants.NT_BASE, "c")
				.where(new Where.Builder()
						.addCondition(new JcrSql2Comparison(null, ComparisonOperators.ISDESCENDANTNODE, "'/'"))
						.and().addCondition(new JcrSql2Comparison("c.*", ComparisonOperators.CONTAINS, "'world'"))
						.and().addCondition(new JcrSql2Comparison(MgnlTypesConstants.JCR_PRIMARYTYPE, ComparisonOperators.NOT_EQUALS, MgnlTypesConstants.FOLDER_TYPE))
						.build())
				.sortAscending("title")
				.build();

		System.out.println(query.toString());

	}

}
