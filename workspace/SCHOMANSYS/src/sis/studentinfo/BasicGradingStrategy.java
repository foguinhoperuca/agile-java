package sis.studentinfo;

public class BasicGradingStrategy implements GradingStrategy {
    @Override
    public int getGradePointsFor(Student.Grade _grade) {
	/*
	 * switch (_grade) { case A: return 4; case B: return 3; case C: return
	 * 2; case D: return 1; case F: default: return 0; }
	 */
	return _grade.getPoints();
    }
}
