package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utility {

    public static String dob_calculation_based_on_age_input(int age) {

        Calendar calendar = Calendar.getInstance(); // get calender or instance of current date and time
        calendar.add(Calendar.YEAR, -age); // decrease calender year by given age
        calendar.set(Calendar.DATE, 1); // set calender date by 1
        calendar.set(Calendar.MONTH, 0); // set calender month by 1 means january
        // below code for getting date in proper format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDOB = dateFormat.format(calendar.getTime());
        System.out.println(formattedDOB);
        return formattedDOB;

    }

    public static String set_day_and_month_in_dob(int age) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -age);
        calendar.set(Calendar.DATE, 29);
        calendar.set(Calendar.MONTH, 4);
        // below code for getting date in proper format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String setDOB = dateFormat.format(calendar.getTime());
        System.out.println(setDOB);
        return setDOB;

    }


}
