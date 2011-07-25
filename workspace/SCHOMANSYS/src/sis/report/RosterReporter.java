package sis.report;

import sis.studentinfo.CourseSession;
import sis.studentinfo.Student;
import static sis.report.StringUtil.NEWLINE;
import static sis.report.StringUtil.ROSTER_REPORT_HEADER;
import static sis.report.StringUtil.ROSTER_REPORT_FOOTER;

public class RosterReporter {

	private CourseSession session;

	public RosterReporter(CourseSession _session) {
		this.session = _session;
	}

	public String getRosterReport() {
		StringBuilder buffer = new StringBuilder();

		writeHeader(buffer);
		writeBody(buffer);
		writeFooter(buffer);

		return buffer.toString();
	}

	public void writeHeader(StringBuilder buffer) {
		buffer.append(ROSTER_REPORT_HEADER);
	}

	public void writeBody(StringBuilder buffer) {
		for (Student student : session.getAllStudents()) {
			buffer.append(student.getName());
			buffer.append(NEWLINE);
		}
	}

	public void writeFooter(StringBuilder buffer) {
		buffer.append(ROSTER_REPORT_FOOTER + session.getAllStudents().size()
				+ NEWLINE);
	}
}
