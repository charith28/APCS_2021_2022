import java.util.*;
import java.io.*;

/**
 * @author 23fernando
 * @version January 20 2022
 * takes a user-inputted word and returns specifc point values for each letter. Implements new concepts of lookup tables, binary search, and ArrayLists
 */
public class ScrabbleScorer {
    private ArrayList<String> dictionary;
    private int[] points = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
    private String alpha;

    /**
     * Default Constructor that initiates word list for each object and creats string for lookup table.
     */
    public ScrabbleScorer(){
        dictionary = new ArrayList<>();
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        buildDictionary();
    }

    /**
     * Implements scanner class to read through "SCRABBLE_WORDS.txt" and append each line as an item in the dictionary list
     * Uses java collections framework to sort dictionary in alphabetical order
     */
    public void buildDictionary(){
        try {
            Scanner read = new Scanner(new File("SCRABBLE_WORDS.txt"));
            while(read.hasNext()) {
               dictionary.add(read.nextLine());

            }
             read.close();

        }
        catch(Exception e){
           e.printStackTrace();
        }

        Collections.sort(dictionary);
    }

    /**
     * Checks in the dictionary arrayList if the provided word is valid
     * @param word - a word which is checked for in the dictionary
     * @return - A boolean that is true if word is in the dictionary list
     */
    public boolean isValidWord(String word){
        return Collections.binarySearch(dictionary, word) >= 0;
    }

    /**
     * Implements a for loop to iterate through each letter of the provided word and gives the appropriate point value by referencing the lookup table
     * @param word - Word that is to be scored
     * @return - returns integer point value for the parameter word
     */
    public int getWordScore(String word){
        int sum = 0;
        for(int i = 0; i< word.length(); i++) {
            sum += points[alpha.indexOf(word.charAt(i))];
        }
        return sum;
    }

    /**
     * Collects user input with the Scanner class and implements methods to validate and score user-given data. Runs in while loop so that user can continue to use program without re-running.
     * @param args - args if needed for testing
     */
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
