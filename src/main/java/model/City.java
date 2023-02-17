package model;

public class City {

    private String city_name;

    private int city_id;

    public City() {
    }

    public City(String city_name) {
        this.city_name = city_name;
    }

    public City(String city_name, int city_id) {
        this.city_name = city_name;
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public long getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    @Override
    public String toString() {
        return "City{" +
                "Город: '" + city_name + '\'' +
                ", city_id=" + city_id +
                '}';
    }
}

