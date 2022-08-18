import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
    public static void main(String[] args) {
        DateDisplay();

        Date date = new Date();
        System.out.println("\nThe current Time is: " + date.toString());
    }

    public static void DateDisplay() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Normal Type Date time is: " +
                simpleDateFormat.format(date));
    }
}
