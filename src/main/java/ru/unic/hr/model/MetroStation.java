
package ru.unic.hr.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class MetroStation {

    @SerializedName("station_name")
    @Expose
    private String stationName;
    @SerializedName("line_name")
    @Expose
    private String lineName;
    @SerializedName("station_id")
    @Expose
    private String stationId;
    @SerializedName("line_id")
    @Expose
    private String lineId;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lng")
    @Expose
    private Double lng;

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("stationName", stationName).append("lineName", lineName).append("stationId", stationId).append("lineId", lineId).append("lat", lat).append("lng", lng).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(lineName).append(stationId).append(lng).append(stationName).append(lat).append(lineId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MetroStation) == false) {
            return false;
        }
        MetroStation rhs = ((MetroStation) other);
        return new EqualsBuilder().append(lineName, rhs.lineName).append(stationId, rhs.stationId).append(lng, rhs.lng).append(stationName, rhs.stationName).append(lat, rhs.lat).append(lineId, rhs.lineId).isEquals();
    }

}
