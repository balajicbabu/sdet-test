package hcom.qa.hotel.validators;


public class HotelIdValidator {

    public static boolean isValidHotelId(String id) { return id.matches("[A-Z]{2}[0-9]{4,9}"); }
}
