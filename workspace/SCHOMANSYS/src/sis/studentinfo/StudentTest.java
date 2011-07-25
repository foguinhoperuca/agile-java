package sis.studentinfo;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;

public class StudentTest extends TestCase {
    private static final int CREDITS = 3;
    private Date startDate;
    @SuppressWarnings("unused")
    private CourseSession session;
    @SuppressWarnings("unused")
    private Student student;

    @Override
    public void setUp() {
	startDate = DateUtil.createDate(2003, 1, 6);
	session = createCourseSession();
	student = new Student("Foo Bar");
    }

    @Test
    public void testCreate() {
	final String firstStudentName = "Jane Doe";
	Student student = new Student(firstStudentName);
	assertEquals(firstStudentName, student.getName());

	final String secondStudentName = "Joe Blow";
	Student secondStudent = new Student(secondStudentName);
	assertEquals(secondStudentName, secondStudent.getName());

	assertEquals(firstStudentName, student.getName());
    }

    @Test
    public void testStudentStatus() {
	Student studentStatus = new Student("Jeff");

	assertEquals(0, studentStatus.getCredits());
	assertFalse(studentStatus.isFulltime());

	studentStatus.addCredit(3);
	assertEquals(3, studentStatus.getCredits());
	assertFalse(studentStatus.isFulltime());

	studentStatus.addCredit(4);
	assertEquals(7, studentStatus.getCredits());
	assertFalse(studentStatus.isFulltime());

	studentStatus.addCredit(5);
	assertEquals(Student.CREDITS_REQUIRED_FOR_FULL_TIME,
		studentStatus.getCredits());
	assertTrue("Credits not enough!!", studentStatus.isFulltime());
    }

    @Test
    public void testInState() {
	Student studentInState = new Student("Foo");
	assertFalse(studentInState.isInState());
	studentInState.setState(Student.IN_STATE);
	assertTrue(studentInState.isInState());
	studentInState.setState("MD");
	assertFalse(studentInState.isInState());
    }

    @Test
    public void testCalculateGPA() {
	Student foo = new Student("Bar");
	assertGpa(foo, 0.0);
	foo.addGrade(Student.Grade.A);
	assertGpa(foo, 4.0);
	foo.addGrade(Student.Grade.B);
	assertGpa(foo, 3.5);
	foo.addGrade(Student.Grade.C);
	assertGpa(foo, 3.0);
	foo.addGrade(Student.Grade.D);
	assertGpa(foo, 2.5);
	foo.addGrade(Student.Grade.F);
	assertGpa(foo, 2.0);
    }

    @Test
    public void testCalculateHonorsStudentGpa() {
	assertGpa(createHonorStudent(), 0.0);
    }

    @SuppressWarnings("unused")
    private Student createHonorStudent(Student.Grade _grade) {
	Student honor = createHonorStudent();
	honor.addGrade(_grade);
	return honor;

    }

    private Student createHonorStudent() {
	Student honor = new Student("Foo Bar");
	honor.setGradingStrategy(new HonorsGradingStrategy());
	return honor;
    }

    private void assertGpa(Student _student, double expectedGpa) {
	assertEquals(expectedGpa, _student.getGpa(), Student.GRADE_TOLERANCE);
    }

    private CourseSession createCourseSession() {
	CourseSession _session = CourseSession.create("ENGL", "101", startDate);
	_session.setNumberOfCredits(CREDITS);
	return _session;
    }
}