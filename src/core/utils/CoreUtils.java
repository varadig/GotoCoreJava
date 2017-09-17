package core.utils;

import core.base.CoreBaseClass;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CoreUtils extends CoreBaseClass {

    public static String timeStamp() {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss a");

        final Calendar calendar = Calendar.getInstance();
        return sdf.format(calendar.getTime());
    }

}
