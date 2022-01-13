import java.util.ArrayList;

public class Chapter11 {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        for(int i = 0;i< list1.size(); i++)
            for (int j = 0; j< list2.size(); i++) {
                if(list1.get(i)==list2.get(j)){
                    list1.remove(i);
                }
            }
    }
}
