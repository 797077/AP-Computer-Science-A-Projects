/**
 * Gibberish Activity
 *
 * @author (Grace Jau)
 * @version (1011)
 */
public class Gibberish{
    String sourceString;
    public Gibberish(){
        Template template = new Template();
        sourceString = template.getSourceString();
    }

    public String makeGibberish(WordList5000 wordList5000){
        int currentSourceIndex = 0;
        int end = 0;
        String resultString = "";
        while(currentSourceIndex<sourceString.length()){
            int otherIndex = currentSourceIndex;
            currentSourceIndex = sourceString.indexOf("<", currentSourceIndex);
            if(currentSourceIndex < 0){
                resultString += sourceString.substring(otherIndex);
                currentSourceIndex = sourceString.length();
            }else{
                resultString += sourceString.substring(otherIndex, currentSourceIndex);
                String placeHolderString = sourceString.substring(currentSourceIndex+1, sourceString.indexOf(">", currentSourceIndex));
                int i = 1;
                while(i == 1){
                    String randomWord = wordList5000.getRandomWordString(placeHolderString);
                    if(randomWord != null){
                        resultString += " " + randomWord + " ";
                        i = 0;
                    }
                }
                currentSourceIndex = sourceString.indexOf("</>", currentSourceIndex) + "</>".length();
            }
        }
        return resultString;
    }
}
