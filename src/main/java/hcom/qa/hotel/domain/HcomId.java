package hcom.qa.hotel.domain;

import java.util.Objects;

public class HcomId {

    private final String id;

    private HcomId(String id) {
        this.id = id;
    }

    public static HcomId create(String id) {
        return new HcomId(id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final HcomId other = (HcomId) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "HcomId{" +
                "id='" + id + '\'' +
                '}';
    }
}
