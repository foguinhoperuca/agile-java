package sis.summer;

import java.util.Date;

import sis.studentinfo.Session;

public class SummerCourseSession extends Session {
    public static SummerCourseSession create(String _department,
	    String _number, Date _startDate) {
	return new SummerCourseSession(_department, _number, _startDate);
    }

    public SummerCourseSession(String _department, String _number,
	    Date _startDate) {
	super(_department, _number, _startDate);
    }

    @Override
    protected int getSessionLength() {
	return 8;
    }
}
