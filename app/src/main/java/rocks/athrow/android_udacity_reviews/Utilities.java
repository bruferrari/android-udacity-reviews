package rocks.athrow.android_udacity_reviews;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Utilities
 * General Utilities
 * Created by josel on 7/5/2016.
 */
public class Utilities {

    /**
     * getDateAsString
     * Convert a date into a string
     * @param date the date
     * @param format the format in which to return the string
     * @return the new formatted date string
     */
    public String getDateAsString(Date date, String format, String timezone) {
        DateFormat formatter = new SimpleDateFormat(format, Locale.getDefault());
        if ( timezone == null){
            formatter.setTimeZone(TimeZone.getDefault());
        }else{
            formatter.setTimeZone(TimeZone.getTimeZone(timezone));
        }
        return formatter.format(date);
    }

    /**
     * getStringAsDate
     * @param dateString a string in date format
     * @param format the resulting date format
     * @return a new date in the specified format
     */
    public Date getStringAsDate(String dateString, String format, String timezone) {
        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.getDefault());
        if ( timezone == null ){
            formatter.setTimeZone(TimeZone.getDefault());
        }else{
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        }
        Date date = new Date();
        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * elapsedTime
     * Get the elapsed time between two dates
     * @param dateStart the date start
     * @param dateEnd the date end
     * @return the elapsed hours and minutes
     */
    public String elapsedTime(Date dateStart, Date dateEnd) {
        long diff = dateEnd.getTime() - dateStart.getTime();
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000);
        String mins =  Long.toString(diffMinutes);
        if ( mins.length() == 1){
            mins = "0" + mins;
        }

        return Long.toString(diffHours) + ":"  + mins;
    }
    /**
     * getTodaysDate
     *
     * @param format the date format in which to return the date
     * @return today's date in the specified format
     */
    public Date getTodaysDate(String format) {
        Date date = new Date();
        String dateString = getDateAsString(date, format, null);
        return getStringAsDate(dateString, format, null);
    }
    /**
     * buildStringFromArray
     * @param stringArray the String[] to convert
     * @param separator   the string separator
     * @return the separated string
     */
    public String buildStringFromArray(ArrayList<String> stringArray, String separator) {
        if (stringArray.size() > 0) {
            StringBuilder nameBuilder = new StringBuilder();
            for (String n : stringArray) {
                nameBuilder.append(n).append(separator);
            }
            nameBuilder.deleteCharAt(nameBuilder.length() - 1);
            return nameBuilder.toString();
        } else {
            return null;
        }
    }
    /**
     * StringSplit
     */
    public String[] stringSplit(String string, String splitCharacter) {
        return string.split(splitCharacter);

    }

}