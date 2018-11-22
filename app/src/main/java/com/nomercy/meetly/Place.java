package com.nomercy.meetly;

public class Place {

    private String placeName;
    private String placeDescription;
    private String placeImage;

    public Place(String placeName, String placeDescription, String placeImage){

        this.placeName=placeName;
        this.placeDescription = placeDescription;
        this.placeImage = placeImage;
    }

    public String getPlaceName() {
        return this.placeName;
    }

    public void setPlaceName(String name) {
        this.placeName = name;
    }

    public String getPlaceDescription() {
        return this.placeDescription;
    }

    public void setPlaceDescription(String company) {
        this.placeDescription = company;
    }

    public String getPlaceImage() {
        return this.placeImage;
    }

    public void setPlaceImage(String image) {
        this.placeImage = image;
    }
}