public class Chapter8 {
    public static boolean sameChar(String str) {
        return str.replace(""+str.charAt(0),"").length()==0;
    }


    public static String noDashSSN(String SSN) {
        return SSN.replace("-", "");
    }
    public static String scrollString(String str){
        return str.substring(1)+(" " + str.charAt(0));
    }
    public static String convertName(String str){
        return str.substring(str.indexOf(",")+2) + " " + str.substring(0, str.indexOf(","));}
    public static String dateStr(String str){
        return str.substring(str.indexOf("/")+1, str.lastIndexOf("/")) + "-" + str.substring(0, str.indexOf("/")) + "-" + str.substring(str.lastIndexOf("/")+1);
    }
    public static void main(String[] args) {
        System.out.println(dateStr("05/31/2019"));
    }
}