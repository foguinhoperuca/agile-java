package sis.report;

import static sis.report.StringUtil.NEWLINE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sis.studentinfo.CourseSession;

public class CourseReport {
	private List<CourseSession> sessions = new ArrayList<CourseSession>();

	public void add(CourseSession _session) {
		sessions.add(_session);
	}

	public String text() {
		return this.toString();
	}

	/**
	 * In text-book, the author use ==> public String test() {...}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		Collections.sort(this.sessions);
		for (CourseSession _session : sessions)
			builder.append(_session.getDepartment() + " "
					+ _session.getNumber() + NEWLINE);
		return builder.toString();
	}
}
