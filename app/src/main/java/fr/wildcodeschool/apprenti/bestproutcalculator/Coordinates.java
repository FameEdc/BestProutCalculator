package fr.wildcodeschool.apprenti.bestproutcalculator;

/**
 * Created by apprenti on 23/01/17.
 */

public class Coordinates {

    private String latitude;
    private String longitude;
    private String smell;
    private String date;


    public Coordinates(String latitude, String longitude, String smell, String date) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.smell = smell;
        this.date = date;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getSmell() {
        return smell;
    }

    public void setSmell(String smell) {
        this.smell = smell;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}

