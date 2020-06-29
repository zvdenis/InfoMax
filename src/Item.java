/*
 * Created by Denis Zvyagintsev on 28.06.2020
 */

import org.w3c.dom.Element;

import java.util.Objects;

public class Item {

    private static final String cityTag = "city";
    private static final String streetTag = "street";
    private static final String houseTag = "house";
    private static final String floorTag = "floor";

    String city;
    String street;
    String house;
    String floor;

    public int getFloor() {
        return Integer.parseInt(floor);
    }

    public Item(Element element) {
        city = element.getAttribute(cityTag);
        street = element.getAttribute(streetTag);
        house = element.getAttribute(houseTag);
        floor = element.getAttribute(floorTag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(city, item.city) &&
                Objects.equals(street, item.street) &&
                Objects.equals(house, item.house) &&
                Objects.equals(floor, item.floor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, house, floor);
    }

    @Override
    public String toString() {
        return city + " " + street + " " + house + " " + floor;
    }
}

