public class Theater {
     Seat[][] theaterSeats;


    /** Constructs a Theater object, as described in part (a).
     * Precondition: seatsPerRow > 0; tier1Rows > 0; tier2Rows >= 0
     */
    public Theater(int seatsPerRow, int tier1Rows, int tier2Rows) {
        theaterSeats = new Seat[tier1Rows+tier2Rows][seatsPerRow];
        for(int i = 0; i < tier1Rows+ tier2Rows; i ++){
            for(int f = 0; f< seatsPerRow; f++){
                if (i < tier1Rows){
                    theaterSeats[i][f] = new Seat(true, 1);
                    System.out.print(1);
                }
                else{
                    theaterSeats[i][f] = new Seat(true,2);
                    System.out.print(2);
                }
            }
            System.out.println();
        }
    }


    /** Returns true if a seat holder was reassigned from the seat at fromRow, fromCol
     * to the seat at toRow, toCol; otherwise it returns false, as described in part (b).
     * Precondition: fromRow, fromCol, toRow, and toCol represent valid row and
     * column positions in the theater.
     * The seat at fromRow, fromCol is not available.
     */
    public boolean reassignSeat(int fromRow, int fromCol, int toRow, int toCol){
        if(theaterSeats[toRow][toCol].isAvailable() && theaterSeats[toRow][toCol].getTier() >=  theaterSeats[fromRow][fromCol].getTier()){
            Seat x = theaterSeats[fromRow][fromCol];
            theaterSeats[fromRow][fromCol].setAvailability(true);
            theaterSeats[toRow][toCol].setAvailability(false);
            return true;
        }
        else{
            return false;
        }
    }

    //public boolean reassignSeat(int fromRow, int fromCol, int toRow, int toCol) {  /* to be implemented in part (b) */  }
    public static void main(String[] args) {
        Theater app = new Theater(3,4,5);
        //System.out.println(theaterSeats);
    }
}
