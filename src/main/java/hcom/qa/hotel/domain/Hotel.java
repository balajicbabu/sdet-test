package hcom.qa.hotel.domain;

import java.util.Objects;

public class Hotel {

    private final HcomId id;
    private final String name;

    public Hotel(HcomId id, String name) {
        this.id = id;
        this.name = name;
    }

    public HcomId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Hotel other = (Hotel) obj;
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        return "HcomId{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
