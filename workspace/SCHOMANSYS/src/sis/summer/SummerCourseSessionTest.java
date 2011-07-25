package sis.summer;

import java.util.Date;

import org.junit.Test;

import sis.studentinfo.DateUtil;
import sis.studentinfo.Session;
import sis.studentinfo.SessionTest;

public class SummerCourseSessionTest extends SessionTest {
    @Test
    public void testEndDate() {
	Date startDate = DateUtil.createDate(2003, 6, 9);
	Session session = SummerCourseSession.create("ENGL", "200",
		startDate);
	Date eightWeeksOut = DateUtil.createDate(2003, 7, 31);
	assertEquals(eightWeeksOut, session.getEndDate());
    }
    
    protected Session createSession(String department, String number, Date _startDate){
	return SummerCourseSession.create(department, number, _startDate);
    }
}
