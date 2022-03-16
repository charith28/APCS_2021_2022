public class Time implements Comparable<Time> {
    private int hours;
    private int mins;

    public Time(){
        hours = 0;
        mins =0 ;
    }

    public Time(int hours, int mins){
        this.hours = hours; this.mins = mins;
    }

    public int totalMins(){
        return hours* 60 + mins;
    }

    public boolean equals(Object other){
        if (other instanceof Time) {
            Time t = (Time) (other);
            return this.hours == t.hours && this.mins == t.mins;
        }else{
            return false;

        }
    }

    public String toString(){
        if(hours< 10)
            return hours + ":" + mins;
        else
            return "0"+ hours + ":" + mins;

    }
    public int compareTo(Time other){
        return this.totalMins()-other.totalMins();
    }

    public static void main(String[] args) {
        Time t1 = new Time(9,30);
        Time t2 = new Time(10,45);
        System.out.println(t1);
    }
}
