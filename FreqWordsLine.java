package old_saxon;

import java.util.*;

/**
 * This class takes a line from Brett Kessler's freqWords file and stores it as an
 * int representing the frequency of the word and a String representing the
 * word itself.
 * @author Buttery Whiskers
 **/
public class FreqWordsLine {

    /**
     * The word and variants being stored.
     **/
    private String word;

    /**
     * The frequency of the word.
     **/
    private int frequency;

    /**
     * The sole constructor for the class, it takes a String, splits the frequency
     * from the word and variants being stored.
     **/
    public FreqWordsLine(String line) {
	// I think the best way to do this is to start from the beginning of the
	// String and find the first character which is neither a space nor a
	// whitespace and split the String in two.
	// parse the first for an integer
	int counter = 0;
	while(Character.isDigit(line.charAt(counter)) ||
	      Character.isWhitespace(line.charAt(counter))) {
	    counter++;
	}
	try {
	    frequency = Integer.parseInt((line.substring(0, counter - 1)).trim());
	    word = OldSaxonString.convertASCII(line.substring(counter,
							      line.length()));
	} catch (NumberFormatException ex) {
	    frequency = -1;
	    System.err.println(ex);
	}
    }

    /**
     * Overrides the default toString method, returns a String with an int followed
     * by a tab character and then the word.
     **/
    public String toString() {
	return frequency + "\t" + word;
    }

    /**
     * Returns a String representing the frequency and word in CSV format, for
     * instance:<br>
     * 1,"uunod"
     **/
    public String toCSVString() {
	return frequency + ",\"" + word + "\"";
    }
}
