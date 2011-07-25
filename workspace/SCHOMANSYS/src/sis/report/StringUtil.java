package sis.report;

public class StringUtil {
	public static final String NEWLINE = System.getProperty("line.separator");
	public static final String ROSTER_REPORT_HEADER = "Student Report"
			+ NEWLINE + "-----" + NEWLINE;
	public static final String ROSTER_REPORT_FOOTER = NEWLINE
			+ " # students = ";

	private StringUtil() {
	}
}
