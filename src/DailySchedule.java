import java.util.ArrayList;

public class DailySchedule {
    private ArrayList<Time> myschedule;

    public DailySchedule(){
        myschedule = new ArrayList<>();
    }
    public void setUpSchedule(){
        myschedule.add(new Time(8,15));
        myschedule.add(new Time(9,30));
        myschedule.add(new Time(10,30));
        myschedule.add(new Time(11,45));
        myschedule.add(new Time(12,35));
        myschedule.add(new Time(13,50));
    }
    public int seansTotalTimeInClass(){
        int sum = 0;
        for(int i = 1; i < myschedule.size(); i+=2){
            sum += (myschedule.get(i).totalMins()-myschedule.get(i-1).totalMins());
        }
        return sum;
    }

    public static void main(String[] args) {
        DailySchedule sean = new DailySchedule();
        sean.setUpSchedule();
        System.out.println(sean.seansTotalTimeInClass());
    }
}
