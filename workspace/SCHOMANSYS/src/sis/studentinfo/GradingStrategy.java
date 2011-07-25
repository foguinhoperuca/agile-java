package sis.studentinfo;

import sis.studentinfo.Student.Grade;

public interface GradingStrategy {
    public int getGradePointsFor(Grade _grade);
}
