package sis.studentinfo;

import sis.studentinfo.Student.Grade;

public class HonorsGradingStrategy extends BasicGradingStrategy {
    @Override
    public int getGradePointsFor(Grade _grade) {
	int points = super.getGradePointsFor(_grade);
	if (points > 0)
	    points += 1;
	return points;
    }
}
