
/**
 * Gibberish Activity
 *
 * @author (Grace Jau)
 * @version (1011)
 */
public class GibberishRunner{
    public static void main(){
        WordList5000 wordList5000 = new WordList5000();//makes new WordList5000
        Gibberish gibberish = new Gibberish();//makes Gibberish object
        System.out.println(gibberish.makeGibberish(wordList5000));//runs makeGibberish method and prints returned String
    }
}
