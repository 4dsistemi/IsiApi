package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

public class Commercial {

    @SerializedName("LocalId")
    private final String local_id;
    @SerializedName("Activation")
    private final String activation;
    @SerializedName("Description")
    private final String description;
    @SerializedName("LastActivation")
    private final String last_activation;
    @SerializedName("Points")
    private final int points;
    @SerializedName("Promo24Week")
    private final int promo_24_week;
    @SerializedName("Latitude")
    private final float latitude;
    @SerializedName("Longitude")
    private final float longitude;
    @SerializedName("Logo")
    private final String logo;

    public Commercial(String local_id, String activation, String description, String last_activation, int points, int promo_24_week, float latitude, float longitude, String logo) {
        this.local_id = local_id;
        this.activation = activation;
        this.description = description;
        this.last_activation = last_activation;
        this.points = points;
        this.promo_24_week = promo_24_week;
        this.latitude = latitude;
        this.longitude = longitude;
        this.logo = logo;
    }

    public String getLocal_id() {
        return local_id;
    }

    public String getActivation() {
        return activation;
    }

    public String getDescription() {
        return description;
    }

    public String getLast_activation() {
        return last_activation;
    }

    public int getPoints() {
        return points;
    }

    public int getPromo_24_week() {
        return promo_24_week;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public String getLogo() {
        return logo;
    }
}
