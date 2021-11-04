public class Chapter7 {

    public static void coinCombo(int cents) {
        int q = 0, d = 0, n = 0, p = 0;
        int count = 0;
        for (q = 0; 25 * q <= cents; q++) {
            for (d = 0; d * 10 + 25 * q <= cents; d++) {
                for (n = 0; 25 * q + d * 10 + 5 * n <= cents; n++) {
                    p = cents - (25 * q + d * 10 + 5 * n);
                    count++;
                    System.out.println(q + " Quarters " + d + " Dimes" + n + " Nickels" + p + " Pennies");
                }
            }
        }
        System.out.print(count);
    }

    public static void main(String[] args) {
            coinCombo(30);
    }
}
