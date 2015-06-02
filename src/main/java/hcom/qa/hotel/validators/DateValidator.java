package hcom.qa.hotel.validators;

import com.google.common.base.Strings;

public class DateValidator {

    public static boolean validate(String checkin, String checkout) {
        return datesNotEmptyOrNull(checkin, checkout) && (datesAreDigits(checkin, checkout));
    }

    private static boolean datesNotEmptyOrNull(String checkin, String checkout) {
        return (!Strings.isNullOrEmpty(checkin) && !Strings.isNullOrEmpty(checkout));
    }

    private static boolean datesAreDigits(String checkin, String checkout) {
        return checkin.matches("[0-9]{8}") && checkout.matches("[0-9]{8}");
    }
}
