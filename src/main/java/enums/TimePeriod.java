package enums;

public enum TimePeriod {

    THIRTY_DAYS("30 дней"),
    SEVEN_DAYS("7 дней"),
    TWENTY_FOUR_HOURS("24 часа");

    private final String timePeriod;

    TimePeriod(String timePeriod){
        this.timePeriod = timePeriod;
    }
    public String getTimePeriod(){
        return this.timePeriod;
    }


}
