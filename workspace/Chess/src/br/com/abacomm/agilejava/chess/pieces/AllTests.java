package br.com.abacomm.agilejava.chess.pieces;

import br.com.abacomm.agilejava.chess.BoardTest;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
    public static Test suite() {
	TestSuite suite = new TestSuite(AllTests.class.getName());
	// $JUnit-BEGIN$
	suite.addTestSuite(PieceTest.class);
	suite.addTestSuite(BoardTest.class);
	// $JUnit-END$
	return suite;
    }

}
