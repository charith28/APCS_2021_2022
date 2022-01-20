import java.util.ArrayList;
import java.util.*;



public class Chapter11 {
    public static ArrayList<String> Reverse(ArrayList<String> x){
        ArrayList<String> rev = new ArrayList<>();
        for (int i = x.size(); i > 0 ; i--) {
            rev.add(x.get(i-1).toString());
        }
        return rev;
    }
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        for(int i = 0;i< list1.size(); i++)
            for (int j = 0; j< list2.size(); i++) {
                if(list1.get(i)==list2.get(j)){
                    list1.remove(i);
                }
            }
        ArrayList<String> temp = new ArrayList<String>();

        temp.add("b");
        temp.add("a");
        temp.add("b");
        temp.add("e");

        System.out.println(Reverse(temp));

    }
}
