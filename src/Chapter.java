import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Chapter {

    private ArrayList<Integer> SmallList = new ArrayList<>(Arrays.asList(3,2,4,5,1));

    public static int arrSum(int[] arr) {
        ArrayList<String> Normal = new ArrayList<>();
        int sum = 0;
        for (int var : arr) {
            sum += var;
        }
        return sum;
    }

    public static ArrayList<String> Reverse(ArrayList<String> x){
        ArrayList<String> rev = new ArrayList<>();
        for (int i = x.size(); i > 0 ; i--) {
            rev.add(x.get(i-1).toString());
        }
        return rev;
    }
    public static int[] twoArrSum(int[][] Arr){
        int[] sums = new int[Arr.length];
        int x = 0;
        for(int[] row: Arr){
            sums[x] = arrSum(row);
            x++;
        }
        return sums;
    }


    public static void main(String[] args) {
        //int[][] arr = {{1,2,3},{2,3,4},{3,4,5}};
        //System.out.println(java.util.Arrays.toString(twoArrSum(arr)));
        String[] list  = {"One" , "Two", "Three"};
        for(String s: list){
            s +="*";

        }
        for(int i = 0; i<3; i++)
            System.out.println(list[i]);
        ArrayList<Integer> SmallList = new ArrayList<>(Arrays.asList(3,2,4,5,1));
        Collections.sort(SmallList);
        SmallList.remove(0);

    }
}
