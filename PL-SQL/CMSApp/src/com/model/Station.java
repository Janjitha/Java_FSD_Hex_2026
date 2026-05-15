package com.model;

public class Station {
    private int id;
    private String stationTitle;
    private String address;
    private StationHead stationHead;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStationTitle() {
        return stationTitle;
    }

    public void setStationTitle(String stationTitle) {
        this.stationTitle = stationTitle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StationHead getStationHead() {
        return stationHead;
    }

    public void setStationHead(StationHead stationHead) {
        this.stationHead = stationHead;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", stationTitle='" + stationTitle + '\'' +
                ", address='" + address + '\'' +
                ", stationHead=" + stationHead +
                '}';
    }
}
