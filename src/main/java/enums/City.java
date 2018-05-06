package enums;

public enum City {

    KYIV("Киев"),
    LVIV("Львов"),
    DNIPRO("Днепр");

    private final String city;

    City(String city){
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }
}
