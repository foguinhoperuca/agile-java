package sis.studentinfo;

import java.util.Date;

/**
 * Provides a representation of a single-semester session of a specific
 * university course.
 * 
 */
public class CourseSession extends Session implements Comparable<CourseSession> {
    private static int count;

    protected CourseSession(String _department, String _number, Date _startDate) {
	super(_department, _number, _startDate);
    }

    public static CourseSession create(String _department, String _number,
	    Date _startDate) {
	incrementCount();
	return new CourseSession(_department, _number, _startDate);
    }

    public static int getCount() {
	return CourseSession.count;
    }

    public static void resetCount() {
	count = 0;
    }

    public static void incrementCount() {
	++count;
    }

    protected int getSessionLength() {
	return 16;
    }

}