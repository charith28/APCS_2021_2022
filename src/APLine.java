public class APLine {
    private int coeffA;
    private int coeffB;
    private int constC;

    public APLine() {
        coeffA = 1;
        coeffB = 1;
    }

    public APLine(int a, int b, int c) {
        coeffA = a;
        coeffB = b;
        constC = c;
    }

    public double getSlope() {
        return -((double) coeffA) / coeffB;
    }

    public boolean isOnLine(int xCoord, int yCoord) {
        return (coeffA * xCoord) + (coeffB * yCoord) + constC == 0;
    }

    public static void main(String[] args) {
        APLine Line1 = new APLine(5, 4, -17);
        boolean onLine1 = Line1.isOnLine(5, -2);
        double slope1 = Line1.getSlope();
    }
}