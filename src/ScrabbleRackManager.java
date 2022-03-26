import java.util.ArrayList;
import java.io.*;
import java.util.Collections;
import java.util.Scanner;

/**
 * The ScrabbleRackManager class creates a random scrabble rack of 7 letters and presents the user with all the possible playable words.
 * @author 23fernando
 * @version 3-25-2022
 */
public class ScrabbleRackManager {
    private ArrayList<ArrayList<String>> dictionary;
    private ArrayList<String> tileRack;
    private ArrayList<String> allTiles;

    /**
     class constructor that builds the dictionary and rack for the user
     **/
    public ScrabbleRackManager() {
        dictionary = new ArrayList<>();
        allTiles = new ArrayList<>();
        tileRack = new ArrayList<>();
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i<26; i++){
            dictionary.add(new ArrayList<>());
        }
        try {
            Scanner read = new Scanner(new File("2019_collins_scrabble.txt"));
            while (read.hasNext()) {
                String word = read.nextLine();
                dictionary.get(alpha.indexOf(word.charAt(0))).add(word);

            }
            read.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        int[] limits = {9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1};
        for(int i = 0; i< 26; i++){
            for(int j = 0; j<limits[i]; j++) {
                allTiles.add((alpha.substring(i,i+1)));
            }
        }
        buildRack();
    }

    private void buildRack(){
        Collections.shuffle(allTiles);
        for (int i = 0; i<7; i++) {
            tileRack.add(allTiles.remove((int) (Math.random() * allTiles.size())));
        }
    }

    /** displays the contents of the player's tile rack */

    public void printRack(){
        System.out.println("Letters in the rack: " + tileRack);
    }
    /** builds and returns an ArrayList of String objects that are values pulled
     from
     * the dictionary/database based on the available letters in the user's tile
     * rack
     * @return playList is an ArrayList of the possible words a user can play*/

    public ArrayList<String> getPlaylist(){
        ArrayList<String> playList = new ArrayList<>();
        for(ArrayList<String> b: dictionary){
            if(!tileRack.contains(b.get(0).substring(0,1))) {
                continue;
            }
            for(String s: b){
                if(s.length()<=7 && isPlayable(s)) {
                    playList.add(s);
                }
            }
        }
        return playList;
    }


    private boolean isPlayable(String word){
        ArrayList<String> copy = new ArrayList<>(tileRack);
        for(int i = 0; i < word.length(); i++){
            if(!copy.remove(word.substring(i,i+1)))
                return false;
        }
        return true;
    }



    /** prints all of the playable words based on the letters in the tile rack */
    public void printMatches(){
        ArrayList<String> plays = getPlaylist();
        boolean bingo = false;
        System.out.println("You can play the following words from the letters in your rack:");
        if (plays.size()==0)
            System.out.println("Sorry, NO words can be played from those tiles.");
        for (int i = 0; i < plays.size(); i++) {
            String word = plays.get(i);
            if(word.length()==7) {
                word += "*";
                bingo = true;
            }
            System.out.print(String.format("%-10s", word));
            if((i+1)%10 == 0)
                System.out.println();

            }
        System.out.println();
        if (bingo) {
            System.out.println("* \t determines bingo");
        }
        }


    /** main method for the class; use only 3 command lines in main */
    public static void main(String[] args){
        ScrabbleRackManager app = new ScrabbleRackManager();
        app.printRack();
        app.printMatches();
    }
}
