
/**
 * A program to allow students to try out different 
 * String methods. 
 * @author Grace Jau
 * @version 1021
 */
public class StringExplorer
{

	public static void main(String[] args)
	{
		String sample = "The quick brown fox jumped over the lazy dog.";
		
		//  Demonstrate the indexOf method.
		int position = sample.indexOf("slow");
		System.out.println ("sample.indexOf(\"slow\") = " + position);
		System.out.println (sample.indexOf("quick", 11));
		
		//  Demonstrate the toLowerCase method.
		String lowerCase = sample.toLowerCase();
		System.out.println ("sample.toLowerCase() = " + lowerCase);
		System.out.println ("After toLowerCase(), sample = " + sample);
		

	}

}

