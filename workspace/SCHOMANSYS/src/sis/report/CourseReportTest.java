package sis.report;

import static sis.report.StringUtil.NEWLINE;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;

import sis.studentinfo.CourseSession;

public class CourseReportTest extends TestCase {
    @Test
    public void testReport() {
	System.out.println("...::: testReport :::...");
	final Date date = new Date();
	CourseReport report = new CourseReport();
	report.add(CourseSession.create("ENGL", "101", date));
	report.add(CourseSession.create("CZEC", "200", date));
	report.add(CourseSession.create("ITAL", "410", date));
	report.add(CourseSession.create("CZEC", "220", date));
	report.add(CourseSession.create("ITAL", "330", date));

	System.out.println(report);
	assertEquals("CZEC 200" + NEWLINE + "CZEC 220" + NEWLINE + "ENGL 101"
		+ NEWLINE + "ITAL 330" + NEWLINE + "ITAL 410" + NEWLINE,
		report.text());

	System.out.println("...::: testReport ended successfully :::...");
    }

}
