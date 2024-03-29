package sis.studentinfo;

import java.util.ArrayList;
import java.util.List;

public class Student {
    public static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    public static String IN_STATE = "CO";
    public static final double GRADE_TOLERANCE = 0.05;

    public enum Grade {
	A(4), B(3), C(2), D(1), F(0);

	private int points;

	Grade(int _points) {
	    this.points = _points;
	}

	public int getPoints() {
	    return points;
	}
    };

    private String name;
    private int credits = 0;
    private String state = "";
    private List<Grade> grades = new ArrayList<Grade>();
    private GradingStrategy gradingStrategy = new BasicGradingStrategy();

    public Student(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public boolean isFulltime() {
	return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
    }

    public void addCredit(int _credits) {
	this.credits += _credits;
    }

    public void addGrade(Grade _grade) {
	grades.add(_grade);
    }

    public double getGpa() {
	double total = 0.0;

	if (grades.isEmpty())
	    return 0.0;

	for (Grade _grade : grades) {
	    total += gradingStrategy.getGradePointsFor(_grade);
	}

	return total / grades.size();
    }

    public int getCredits() {
	return credits;
    }

    public boolean isInState() {
	return state.toUpperCase().equals(Student.IN_STATE);
    }

    public void setState(String state) {
	this.state = state;
    }

    public void setGradingStrategy(GradingStrategy gradingStrategy) {
	this.gradingStrategy = gradingStrategy;
    }
}