package br.com.abacomm.agilejava.chess.util;

import br.com.abacomm.agilejava.chess.exception.ConvertIndexException;

public class StringUtil {
    public static final String BLANK = ".";
    public static final String NEWLINE = System.getProperty("line.separator");

    public static String appendNewLine(String _text) {
	return _text + NEWLINE;
    }

    public static int convertIndex(String index) throws ConvertIndexException {
	if (index.equals("a"))
	    return 7;
	else if (index.equals("b"))
	    return 6;
	else if (index.equals("c"))
	    return 5;
	else if (index.equals("d"))
	    return 4;
	else if (index.equals("e"))
	    return 3;
	else if (index.equals("f"))
	    return 2;
	else if (index.equals("g"))
	    return 1;
	else if (index.equals("h"))
	    return 0;
	else
	    throw new ConvertIndexException();
    }
}
