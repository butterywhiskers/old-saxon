package old_saxon;

/**
 * This class converts Strings to Unicode of two types, one from the
 * concordance (full ASCII), the other being the Heliand text containing
 * unconverted eth and crossed b characters. For both programs in this package.
 * @author Buttery Whiskers
 **/
public class OldSaxonString {

    /**
     * Converts d= to an eth and b= to a crossed b.
     **/
    public static String convert(String line) {
	line = line.replace("d=", "ð");
        line = line.replace("b=", "ƀ");
	return line;
    }

    /**
     * Converts two types of eths (these come from the original Heliand
     * edition by Behagel and I've kept them, even if it's due to the printer
     * alternating curved and straight eths), crossed bs and vowels followed
     * by a ^ into a vowel with a ^ above.
     **/
    public static String convertASCII(String line) {
        line = line.replace("d=", "đ");
        line = line.replace("b=", "ƀ");
        line = line.replace("d/", "ð");
        line = line.replace("a^", "â");
        line = line.replace("e^", "ê");
        line = line.replace("i^", "î");
        line = line.replace("o^", "ô");
        line = line.replace("u^", "û");
        line = line.replace("A^", "Â");
        line = line.replace("E^", "Ê");
        line = line.replace("I^", "Î");
        line = line.replace("O^", "Ô");
        line = line.replace("U^", "Û");
	return line;
    }

}
