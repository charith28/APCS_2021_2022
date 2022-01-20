import java.util.*;
import java.io.*;

/**
 *
 */
public class ScrabbleScorer {
    private ArrayList<String> dictionary;
    private int[] points = {1,3,3,2,1,4,2,41,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
    private String alpha;

    /**
     *
     */
    public ScrabbleScorer(){
        dictionary = new ArrayList<>();
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        buildDictionary();
    }

    /**
     *
     */
    public void buildDictionary(){
        try {
            Scanner read = new Scanner(new File("SCRABBLE_WORDS.txt"));
            while(read.hasNext()) {
               dictionary.add(read.nextLine());
            }
        }
        catch(Exception e){
           e.printStackTrace();
        }
        Collections.sort(dictionary);
    }

    public boolean isValidWord(String word){
        return Collections.binarySearch(dictionary, word) >= 0;
    }

    public int getWordScore(String word){
        int sum = 0;
        for(int i = 0; i< word.length()-1; i++) {
            sum += points[alpha.indexOf(word.charAt(i))];
        }
        return sum;
    }

    public static void main(String[] args) {
        ScrabbleScorer app = new ScrabbleScorer();
        System.out.println("* Welcome to the Scrabble Word Scorer app *");
        String userWord;
        Scanner userIn = new Scanner(System.in);
        try{
            while(true){
                System.out.print("Enter a word to score or 0 to quit: ");
                userWord = userIn.nextLine();
                if(userWord.equals("0"))
                    break;
                else{
                    if(app.isValidWord(userWord.toUpperCase())) {
                        System.out.println(userWord + " = " + app.getWordScore(userWord.toUpperCase()));
                    }
                    else{
                        System.out.println(userWord + " is not a valid word in the dictionary");
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


}
