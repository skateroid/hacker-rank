package week1;

public class TimeConversion {

    public static void main(String[] args) {
        System.out.println(timeConversion("07:05:45PM"));
    }

    public static String timeConversion(String s) {
        // Write your code here
        String hour = s.substring(0, 2);
        String min = s.substring(3, 5);
        String sec = s.substring(6, 8);
        String part = s.substring(s.length() - 2);

        if (part.equals("AM")) {
            if (hour.equals("12")) hour = "00";
            return String.join(":", hour, min, sec);
        } else {
            if (hour.equals("12")) hour = "12";
            else hour = String.valueOf(Integer.parseInt(hour) + 12);
            return String.join(":", hour, min, sec);
        }
    }
}
