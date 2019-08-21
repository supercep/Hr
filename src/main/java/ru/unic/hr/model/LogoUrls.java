
package ru.unic.hr.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class LogoUrls {

    @SerializedName("240")
    @Expose
    private String _240;
    @SerializedName("90")
    @Expose
    private String _90;
    @SerializedName("original")
    @Expose
    private String original;

    public String get240() {
        return _240;
    }

    public void set240(String _240) {
        this._240 = _240;
    }

    public String get90() {
        return _90;
    }

    public void set90(String _90) {
        this._90 = _90;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("_240", _240).append("_90", _90).append("original", original).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(original).append(_240).append(_90).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LogoUrls) == false) {
            return false;
        }
        LogoUrls rhs = ((LogoUrls) other);
        return new EqualsBuilder().append(original, rhs.original).append(_240, rhs._240).append(_90, rhs._90).isEquals();
    }

}
