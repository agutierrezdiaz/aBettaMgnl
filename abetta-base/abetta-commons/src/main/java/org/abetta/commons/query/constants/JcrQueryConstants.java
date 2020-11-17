package org.abetta.commons.query.constants;

public class JcrQueryConstants {

	public static final String SELECT = "SELECT";

	public static final String FROM = "FROM";

	/**
	 * as
	 */
	public static final String ALIAS = "as";

	public static final String WHERE = "WHERE";

	public static final String AND = "AND";

	public static final String OR = "OR";

	public static final String OR_NOT = "OR NOT";

	/**
	 * =
	 */
	public static final String EQUALS = "=";

	/**
	 * <>
	 */
	public static final String NOT_EQUALS = "<>";

	/**
	 * >
	 */
	public static final String GREATER_THAN = ">";

	/**
	 * <
	 */
	public static final String LESS_THAN = "<";

	/**
	 * >=
	 */
	public static final String GREATER_THAN_OR_EQUALS = ">=";

	/**
	 * <=
	 */
	public static final String LESS_THAN_OR_EQUALS = "<=";

	public static final String CONTAINS = "contains(%property%, %s)";

	public static final String ISDESCENDANTNODE = "ISDESCENDANTNODE(%s)";

	public static final String ORDER_BY = "ORDER BY";

	public static final String ASC = "ASC";

	public static final String DESC = "DESC";

	public static final String CAST_DATE = "CAST('%s' AS DATE)";

	public static final String LOWER_CASE = "lower(%s)";

	public static final String UPPER_CASE = "upper(%s)";
	
	public static final String COMPARATION_FORMAT = " %property% %c %s ";

	public static final String CONDITION_FORMAT = " %c ";

}
