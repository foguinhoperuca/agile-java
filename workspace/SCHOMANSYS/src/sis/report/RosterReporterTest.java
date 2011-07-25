package sis.report;

import static sis.report.StringUtil.NEWLINE;
import static sis.report.StringUtil.ROSTER_REPORT_FOOTER;
import static sis.report.StringUtil.ROSTER_REPORT_HEADER;
import junit.framework.TestCase;

import org.junit.Test;

import sis.studentinfo.CourseSession;
import sis.studentinfo.DateUtil;
import sis.studentinfo.Student;

public class RosterReporterTest extends TestCase {
    private CourseSession session;

    @Override
    public void setUp() {
	// session = new CourseSession("ENGL", "101", DateUtil.createDate(2003,
	// 1, 5));
	session = CourseSession.create("ENGL", "101",
		DateUtil.createDate(2003, 1, 5));
    }

    @Test
    public void testRosterReport() {
	session.enroll(new Student("Joseph"));
	session.enroll(new Student("Mary"));

	String rosterReport = new RosterReporter(session).getRosterReport();
	System.out.println(":::Test to see report:::" + NEWLINE + rosterReport);
	assertEquals(ROSTER_REPORT_HEADER + "Joseph" + NEWLINE + "Mary"
		+ NEWLINE + ROSTER_REPORT_FOOTER + "2" + NEWLINE, rosterReport);
    }
}
