
package ru.unic.hr.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Address {

    @SerializedName("city")
    @Expose
    private Object city;
    @SerializedName("street")
    @Expose
    private Object street;
    @SerializedName("building")
    @Expose
    private Object building;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("lat")
    @Expose
    private Object lat;
    @SerializedName("lng")
    @Expose
    private Object lng;
    @SerializedName("raw")
    @Expose
    private Object raw;
    @SerializedName("metro")
    @Expose
    private Metro metro;
    @SerializedName("metro_stations")
    @Expose
    private List<MetroStation> metroStations = new ArrayList<MetroStation>();
    @SerializedName("id")
    @Expose
    private String id;

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = city;
    }

    public Object getStreet() {
        return street;
    }

    public void setStreet(Object street) {
        this.street = street;
    }

    public Object getBuilding() {
        return building;
    }

    public void setBuilding(Object building) {
        this.building = building;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getLat() {
        return lat;
    }

    public void setLat(Object lat) {
        this.lat = lat;
    }

    public Object getLng() {
        return lng;
    }

    public void setLng(Object lng) {
        this.lng = lng;
    }

    public Object getRaw() {
        return raw;
    }

    public void setRaw(Object raw) {
        this.raw = raw;
    }

    public Metro getMetro() {
        return metro;
    }

    public void setMetro(Metro metro) {
        this.metro = metro;
    }

    public List<MetroStation> getMetroStations() {
        return metroStations;
    }

    public void setMetroStations(List<MetroStation> metroStations) {
        this.metroStations = metroStations;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("city", city).append("street", street).append("building", building).append("description", description).append("lat", lat).append("lng", lng).append("raw", raw).append("metro", metro).append("metroStations", metroStations).append("id", id).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(raw).append(building).append(metro).append(description).append(street).append(lng).append(metroStations).append(lat).append(city).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Address) == false) {
            return false;
        }
        Address rhs = ((Address) other);
        return new EqualsBuilder().append(id, rhs.id).append(raw, rhs.raw).append(building, rhs.building).append(metro, rhs.metro).append(description, rhs.description).append(street, rhs.street).append(lng, rhs.lng).append(metroStations, rhs.metroStations).append(lat, rhs.lat).append(city, rhs.city).isEquals();
    }

}
