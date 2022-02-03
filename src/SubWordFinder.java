import java.util.*;
import java.io.*;

/**
 * @author 23fernando
 * @version - 2/1/2022
 * Parses through a file and finds subword using a binary search method of O(log(n)) efficiency.
 */
public class SubWordFinder implements WordFinder {
    private ArrayList<ArrayList<String>>dictionary;
    String alpha = "abcdefghijklmnopqrstuvwxyz";

    /**
     * constructor for SubWordFinder object that creates a 2d ArrayList of strings
     * calls the populateDictionary method to fill the new list
     */
    public SubWordFinder(){
        dictionary = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            dictionary.add(new ArrayList<String>());
        }
        populateDictionary();
    }

    /**
     * Implements binary search method and parses parameter to find the correct bucket to search
     * @param word The item to be searched for in dictionary
     * @return a boolean to tell whether the provided word is in the dictionary
     */
    public boolean inDictionary(String word){
        int index = alpha.indexOf(word.charAt(0));
        ArrayList<String> bucket = dictionary.get(index);
        return indexOf(bucket, word);
        //return Collections.binarySearch(bucket, word) >= 0;
    }

    /**
     * A binary search method of O(log(n)) efficiency which implements .compareTo() method defined in SubWord class
     * @param temp - ArrayList of strings to scan
     * @param word - the word to scan for
     * @return - returns if a value is or is not in provided array list in boolean form
     */
    private boolean indexOf(ArrayList<String> temp, String word){
        int lower = 0;
        int upper = temp.size()-1;
           while(lower<=upper) {
               int median = lower + (upper-lower)/2;
               if (temp.get(median).compareTo(word) == 0) {
                   return true;
               } if (temp.get(median).compareTo(word) < 0) {
                   lower = median+1;
               } else {
                   upper = median-1;
               }
           }
           return false;
    }

    /**
     * A method which parses dictionary 2D ArrayList uses a for loop to break each word into two halves and checks if each half is a word.
     * @return - a ArrayList of SubWord objects which contains the root word and its two constituent Sub-words
     */
    public ArrayList<SubWord> getSubWords() {
        ArrayList<SubWord> temp = new ArrayList<>();
        for (ArrayList<String> bucket : dictionary) {
            for (String word : bucket) {
                if(word.length()>5) {
                    for (int i = 2; i < word.length() - 2; i++) {
                        if (inDictionary(word.substring(0,i)) && inDictionary(word.substring(i))){
                            temp.add(new SubWord(word, word.substring(0, i), word.substring(i)));
                    }
                    }
                }
            }

        }
        return temp;
    }


    /**
     * Parses defined .txt file and enters all of the words into the appropriate bucket in the dictionary arrayList.
     */
    public void populateDictionary(){
        try {
            Scanner rd = new Scanner(new File("words_all_os.txt"));
            while(rd.hasNext()){
              String word = rd.nextLine();
              dictionary.get(alpha.indexOf(word.charAt(0))).add(word);
            }
            rd.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Creates a new SubWordFinder object and prints all of the SubWords implementing the toString method defined in SubWord.
     * EXTRA: Outputs an arraylist of words which are Subwords that have more than one permutation
     * @param args - args if needed for testing
     */
    public static void main(String[] args) {
        int count = 1, mcount = 0;
        String prev= "";
        ArrayList<String> popSub = new ArrayList<String>();
        SubWordFinder app = new SubWordFinder();
        for(SubWord a: app.getSubWords()){
               System.out.println(a);
               if(prev.equals(a.getRoot())){
                   count+=1;

                   if(count > mcount)
                       popSub.add(a.getRoot());
               }else {
                   count = 0;
                   prev = a.getRoot();
               }
            }
        System.out.println("EXTRA \nA Special shoutout to these SubWords for being exemplary:");
        for(String popular: popSub){
            System.out.println("- *" + popular + "*");
        }
        }

}
