package hcom.qa.hotel;

import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import hcom.qa.availability.AvailabilityService;
import hcom.qa.availability.AvailabilityWindow;
import hcom.qa.hotel.dao.HotelsDao;
import hcom.qa.hotel.domain.HcomDateFormatter;
import hcom.qa.hotel.domain.HcomId;
import hcom.qa.hotel.domain.Hotel;
import hcom.qa.hotel.validators.DateValidator;
import hcom.qa.hotel.validators.HotelIdValidator;
import org.joda.time.DateTime;
import org.joda.time.Days;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

import static java.util.Collections.emptySet;

public class HotelService {

    private HotelsDao hotelsDao;
    private final AvailabilityService availabilityService;

    public HotelService(HotelsDao hotelsDao, AvailabilityService availabilityService) {

        this.hotelsDao = hotelsDao;
        this.availabilityService = availabilityService;
    }

    public Optional<Hotel> find(String hotelId) {

        if (!HotelIdValidator.isValidHotelId(hotelId)) {
            throw new IllegalArgumentException("Invalid id: " + hotelId);
        }

        return hotelsDao.find(hotelId);
    }

    public Set<HcomId> findAvailable(String from, String to) {

        if (!DateValidator.validate(from, to)) {
            throw new IllegalArgumentException("Date Invalid");
        }

        return findAvailableHotels(
                HcomDateFormatter.format(from),
                HcomDateFormatter.format(to)
        );
    }

    private Set<HcomId> findAvailableHotels(Date checkIn, Date checkOut) {

        int numberOfNights = calculateNumberOfNights(checkIn, checkOut);

        if (numberOfNights < 1) {
            return emptySet();
        }

        Set<HcomId> allHotels = hotelsDao.findAll();
        Multimap<HcomId, AvailabilityWindow> hotelsWithAvailableDates = availabilityService.findDates(allHotels);

        Set<HcomId> hotelsAvailable = Sets.newHashSet();
        for (HcomId id : hotelsWithAvailableDates.keySet()) {
            Collection<AvailabilityWindow> availabilityWindows = hotelsWithAvailableDates.get(id);

            for (AvailabilityWindow availabilityWindow : availabilityWindows) {

                if (checkIn.equals(availabilityWindow.from()) && checkOut.equals(availabilityWindow.to())) {
                    hotelsAvailable.add(id);
                }
            }
        }

        return hotelsAvailable;
    }

    private int calculateNumberOfNights(Date checkin, Date checkout) {

        DateTime checkinDate = new DateTime(checkin);
        DateTime checkoutDate = new DateTime(checkout);

        Days days = Days.daysBetween(checkinDate, checkoutDate);

        return days.getDays();
    }
}


