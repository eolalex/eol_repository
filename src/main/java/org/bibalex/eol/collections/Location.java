package org.bibalex.eol.collections;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Location {

    private String locationCreated;
    private String genericLocation;
    private String spatialLocation;
    private Double longitude;
    private Double latitude;
    private Double altitude;

    public String getLocationCreated() {
        return locationCreated;
    }

    public void setLocationCreated(String locationCreated) {
        this.locationCreated = locationCreated;
    }

    public String getGenericLocation() {
        return genericLocation;
    }

    public void setGenericLocation(String genericLocation) {
        this.genericLocation = genericLocation;
    }

    public String getSpatialLocation() {
        return spatialLocation;
    }

    public void setSpatialLocation(String spatialLocation) {
        this.spatialLocation = spatialLocation;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }
}
