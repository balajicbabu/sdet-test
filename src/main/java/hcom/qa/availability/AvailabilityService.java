package hcom.qa.availability;

import com.google.common.collect.Multimap;
import hcom.qa.hotel.domain.HcomId;

import java.util.Set;

public interface AvailabilityService {

    Multimap<HcomId, AvailabilityWindow> findDates(Set<HcomId> hotels);
}
