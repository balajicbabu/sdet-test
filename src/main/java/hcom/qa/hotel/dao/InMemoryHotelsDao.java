package hcom.qa.hotel.dao;

import hcom.qa.hotel.domain.HcomId;
import hcom.qa.hotel.domain.Hotel;

import java.util.*;

public class InMemoryHotelsDao implements HotelsDao {

    private Map<HcomId, Hotel> hotels;

    public InMemoryHotelsDao() {
        this.hotels = new HashMap<>();
    }

    public void addHotelToDatabase(Hotel hotel) {
        hotels.put(hotel.getId(), hotel);
    }

    @Override
    public Optional<Hotel> find(String hotelId) {

        HcomId id = HcomId.create(hotelId);

        return Optional.ofNullable(hotels.get(id));
    }

    @Override
    public Set<HcomId> findAll() {
        return hotels.keySet();
    }
}
