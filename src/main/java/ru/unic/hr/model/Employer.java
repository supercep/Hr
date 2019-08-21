
package ru.unic.hr.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Employer {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("alternate_url")
    @Expose
    private String alternateUrl;
    @SerializedName("logo_urls")
    @Expose
    private LogoUrls logoUrls;
    @SerializedName("vacancies_url")
    @Expose
    private String vacanciesUrl;
    @SerializedName("trusted")
    @Expose
    private Boolean trusted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlternateUrl() {
        return alternateUrl;
    }

    public void setAlternateUrl(String alternateUrl) {
        this.alternateUrl = alternateUrl;
    }

    public LogoUrls getLogoUrls() {
        return logoUrls;
    }

    public void setLogoUrls(LogoUrls logoUrls) {
        this.logoUrls = logoUrls;
    }

    public String getVacanciesUrl() {
        return vacanciesUrl;
    }

    public void setVacanciesUrl(String vacanciesUrl) {
        this.vacanciesUrl = vacanciesUrl;
    }

    public Boolean getTrusted() {
        return trusted;
    }

    public void setTrusted(Boolean trusted) {
        this.trusted = trusted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("url", url).append("alternateUrl", alternateUrl).append("logoUrls", logoUrls).append("vacanciesUrl", vacanciesUrl).append("trusted", trusted).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(trusted).append(alternateUrl).append(name).append(vacanciesUrl).append(logoUrls).append(url).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Employer) == false) {
            return false;
        }
        Employer rhs = ((Employer) other);
        return new EqualsBuilder().append(id, rhs.id).append(trusted, rhs.trusted).append(alternateUrl, rhs.alternateUrl).append(name, rhs.name).append(vacanciesUrl, rhs.vacanciesUrl).append(logoUrls, rhs.logoUrls).append(url, rhs.url).isEquals();
    }

}
