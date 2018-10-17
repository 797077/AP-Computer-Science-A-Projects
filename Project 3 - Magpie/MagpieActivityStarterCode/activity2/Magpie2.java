/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2{
    /**
     * Get a default greeting 	
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";//initial comment
    }

    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement){
        String response = "";
        if((statement.trim()).length()<1){//if the user does not respond with any characters
            return "Say something, please.";
        }
        if (statement.indexOf("no") >= 0){//keyword "no"
            response = "Why so negative?";
        }else if (statement.indexOf("mother") >= 0
        || statement.indexOf("father") >= 0
        || statement.indexOf("sister") >= 0
        || statement.indexOf("brother") >= 0){//keywords about family
            response = "Tell me more about your family.";
        }else if(statement.indexOf("dog") >= 0
        || statement.indexOf("cat") >= 0){// keywords about animals
            response = "Tell me more about your pets.";
        }else if(statement.indexOf("Mr.") >= 0
        || statement.indexOf("Mrs.") >= 0
        || statement.indexOf("Ms.") >= 0
        || statement.indexOf("Miss") >= 0){//keywords about teachers
            response = "They sound like a good teacher.";
        }else if(statement.indexOf("color") >= 0){//keywords about colors
            response = "That's interesting. My favorite color is purple.";
        }else if(statement.indexOf("movie") >= 0){//keywords about movies
            response = "I love movies!";
        }else if(statement.indexOf("cookie") >= 0
        || statement.indexOf("cake") >= 0
        || statement.indexOf("ice cream") >= 0
        || statement.indexOf("donut") >= 0){//keywords about dessert
            response = "I love desserts!";
        }else{
            response = getRandomResponse();
        }
        return response;
    }

    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse(){
        final int NUMBER_OF_RESPONSES = 4;//when all else fails, generates a random, generic response
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }

        return response;
    }
}
