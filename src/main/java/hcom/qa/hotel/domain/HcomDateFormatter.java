package hcom.qa.hotel.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HcomDateFormatter {

    public static final String DATE_FORMAT = "ddMMyyyy";

    public static Date format(String date) {

        try {
            SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
            return formatter.parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Date invalid: " + date);
        }
    }
}
