package old_saxon;

import java.util.*;
import java.io.*;

/**
 * Entry class for the project to turn B Kessler's freqWords file into a CSV file.
 * @author Buttery Whiskers
 **/
public class FreqWords {

    /**                                                                             
     *The BufferedReader.
     **/
    private BufferedReader in;

    /**
     * The output stream.
     **/
    private PrintStream out;
    
    public FreqWords(String input_file, String output_file) {
        try {
	    // initialise input stream
	    in = new BufferedReader(new FileReader(new File(input_file)));
	    // initialise output stream
	    if(output_file == null) {
		out = System.out;
	    }else {
		out = new PrintStream(new PrintStream(output_file), true);
	    }

	    Reading the input and printing out each word line by line
	    String input;
	    while((input = in.readLine()) != null) {
		FreqWordsLine f = new FreqWordsLine(input);
		out.println(f.toCSVString());
	    }

	    // close the IO streams
	    in.close();
	    out.close();
	} catch (IOException ex) {System.err.println(ex);}
	
    }
    
    public static void main(String[] args) {
	// Command message if no arguments, --help or more than two arguments
	if(args.length == 0 || args[0].equals("--help") ||
	   args.length > 2) {
	    System.err.println("java old_saxon.FreqWords input.txt output.csv\n" +
			       "This program will take either one or two " +
			       "arguments: the first obligatory argument is an " +
			       "input file and the second optional argument is " +
			       "an output file. If there is no output file given " +
			       "output is passed to the standard output.");
	    System.exit(1);
	}
	
	String input, output = null;
	input = args[0];
	if(args.length > 1)
	    output = args[1];
       	FreqWords f = new FreqWords(input, output);
    }
    
}
