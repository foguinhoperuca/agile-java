package sis.studentinfo;

import junit.framework.TestCase;

import org.junit.Test;

public class HonorsGradingStrategyTest extends TestCase {

    @Test
    public void testGetGradePointsForGrade() {
	HonorsGradingStrategy strategy = new HonorsGradingStrategy();
	assertEquals(5, strategy.getGradePointsFor(Student.Grade.A));
	assertEquals(4, strategy.getGradePointsFor(Student.Grade.B));
	assertEquals(3, strategy.getGradePointsFor(Student.Grade.C));
	assertEquals(2, strategy.getGradePointsFor(Student.Grade.D));
	assertEquals(0, strategy.getGradePointsFor(Student.Grade.F));
    }

}
