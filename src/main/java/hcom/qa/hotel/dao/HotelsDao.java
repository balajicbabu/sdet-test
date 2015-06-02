package hcom.qa.hotel.dao;

import hcom.qa.hotel.domain.HcomId;
import hcom.qa.hotel.domain.Hotel;

import java.util.Optional;
import java.util.Set;

public interface HotelsDao {

    Optional<Hotel> find(String hotelId);

    Set<HcomId> findAll();
}
