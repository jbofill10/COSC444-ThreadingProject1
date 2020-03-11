package edu.frostburg.cosc444;

public class Record {
    private String id;
    private String districtName;
    private String neighborhood;
    private String street;
    private String weekday;
    private String month;
    private String partOfDay;
    private int victims;

    public Record(String id, String districtName, String neighborhood, String street, String weekday, String month, String partOfDay, int victims) {
        this.id = id;
        this.districtName = districtName;
        this.neighborhood = neighborhood;
        this.street = street;
        this.weekday = weekday;
        this.month = month;
        this.partOfDay = partOfDay;
        this.victims = victims;
    }

    public synchronized String getPartOfDay(){
        return this.partOfDay;
    }

    public synchronized void setPartOfDay(String partOfDay){
        this.partOfDay = partOfDay;
    }

    public synchronized String getId() {
        return id;
    }

    public synchronized void setId(String id) {
        this.id = id;
    }

    public synchronized String getDistrictName() {
        return districtName;
    }

    public synchronized void setDistrictName(String name) {
        this.districtName = name;
    }

    public synchronized String getNeighborhood() {
        return neighborhood;
    }

    public synchronized void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public synchronized String getStreet() {
        return street;
    }

    public synchronized void setStreet(String street) {
        this.street = street;
    }

    public synchronized String getWeekday() {
        return weekday;
    }

    public synchronized void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public synchronized String getMonth() {
        return month;
    }

    public synchronized void setMonth(String month) {
        this.month = month;
    }

    public synchronized int getVictims() {
        return victims;
    }

    public synchronized void setVictims(int victims) {
        this.victims = victims;
    }

    public String toString(){
        return String.format("%-10s " +
                        "| %-20s " +
                        "| %-40s " +
                        "| %-40s " +
                        "| %-10s " +
                        "| %-10s " +
                        "| %-10s " +
                        "| %-10s ",
                this.id,
                this.districtName,
                this.neighborhood,
                this.street,
                this.weekday,
                this.month,
                this.partOfDay,
                this.victims);
    }

}
