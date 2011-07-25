package sis.studentinfo;

import java.util.Date;

import org.junit.Test;

public class CourseSessionTest extends SessionTest {
    @SuppressWarnings("unused")
    private CourseSession session;

    @Override
    protected Session createSession(String _department, String _number,
	    Date _startDate) {
	return CourseSession.create(_department, _number, _startDate);
    }

    @Test
    public void testCourseDates() {
	Date startDate = DateUtil.createDate(2003, 1, 6);
	Session session = createSession("ENGL", "101", startDate);
	Date sixteenWeeksOut = DateUtil.createDate(2003, 4, 26);
	assertEquals(sixteenWeeksOut, session.getEndDate());
    }

    @Test
    public void testCount() {
	CourseSession.resetCount();
	System.out
		.println(" CourseSession.count = " + CourseSession.getCount());

	createSession("", "", new Date());
	assertEquals(1, CourseSession.getCount());
	System.out
		.println(" CourseSession.count = " + CourseSession.getCount());

	createSession("", "", new Date());
	assertEquals(2, CourseSession.getCount());
	System.out
		.println(" CourseSession.count = " + CourseSession.getCount());
    }
}