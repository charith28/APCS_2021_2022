public class Hailstone {
    public static int hailstoneLength(int n) {
        int length = 1;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            }
            else{
                n = (3 * n) + 1;
            }
            length++;
            System.out.println(n);
        }
    System.out.println(length);
    return length;
    }

    public static boolean isLongSeq(int n){
        return hailstoneLength(n)>n;
    }

    public static double propLong(int n) {
        int count = 0;
        for(int i = 1; i <= n; i++){
            //System.out.println(isLongSeq(hailstoneLength(i)));
            if(isLongSeq(i)) {
                count+= 1;
            }
        }
    return count*1.0/n;
    }

    public static void main(String[] args) {
        System.out.println(propLong(10));
    }
}
