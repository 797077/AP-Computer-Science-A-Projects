/**
 * Gibberish Activity
 *
 * @author (Grace Jau)
 * @version (1011)
 */
public class Gibberish{
    String sourceString;//declares sourceString
    public Gibberish(){//Constructor
        Template template = new Template();//makes new Template object
        sourceString = template.getSourceString();//initializes sourceString to a String from template
    }

    public String makeGibberish(WordList5000 wordList5000){
        int currentSourceIndex = 0;//declares and initializes the starting point index
        String resultString = "";//declares resultString, which will have words appended to make the final gibberish sentence
        while(currentSourceIndex<sourceString.length()){//will exit while loop when the gibberish sentence has been completely "fixed"
            int otherIndex = currentSourceIndex;//a placeholder for currentSourceIndex
            currentSourceIndex = sourceString.indexOf("<", currentSourceIndex);//finds the next place, if any, where a word needs to be appended
            if(currentSourceIndex < 0){//if there are no more places to append words to fill in the gibberish
                resultString += sourceString.substring(otherIndex);//appends the rest of sourceString
                currentSourceIndex = sourceString.length();//allows program to exit loop
            }else{
                resultString += sourceString.substring(otherIndex, currentSourceIndex);//adds the parts of sourceString from the last currentSourceIndex to the current position
                String placeHolderString = sourceString.substring(currentSourceIndex+1, sourceString.indexOf(">", currentSourceIndex));//initializes placeHolderString to the part of speech of the random word that will be added
                int i = 1;// while loop keeps finding randomWord until randomWord is not null
                while(i == 1){
                    String randomWord = wordList5000.getRandomWordString(placeHolderString);
                    if(randomWord != null){
                        resultString += " " + randomWord + " ";//appends randomWord to resultString
                        i = 0;
                    }
                }
                currentSourceIndex = sourceString.indexOf("</>", currentSourceIndex) + "</>".length();//moves to the end of the section that has just been filled in
            }
        }
        return resultString;
    }
}
