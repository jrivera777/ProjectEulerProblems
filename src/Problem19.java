import java.util.Calendar;
import java.util.Date;

public class Problem19
{
    public static void main(String [] args)
    {
        Calendar cal = Calendar.getInstance();
        cal.set(1901, 0, 1);
        System.out.println(cal.getTime());
        int sundays = 0;
        Date d = null;
        do
        {
            d = cal.getTime();
            if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            {
                sundays++;
                //System.out.println(d);
            }
            cal.add(Calendar.MONTH, 1);
            System.out.println(d);
        }
        while(cal.get(Calendar.YEAR) < 2001);

        System.out.println(sundays);
    }
}
