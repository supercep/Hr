
package ru.unic.hr.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Item {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("premium")
    @Expose
    private Boolean premium;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("department")
    @Expose
    private Object department;
    @SerializedName("has_test")
    @Expose
    private Boolean hasTest;
    @SerializedName("response_letter_required")
    @Expose
    private Boolean responseLetterRequired;
    @SerializedName("area")
    @Expose
    private Area area;
    @SerializedName("salary")
    @Expose
    private Salary salary;
    @SerializedName("type")
    @Expose
    private Type type;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("response_url")
    @Expose
    private Object responseUrl;
    @SerializedName("sort_point_distance")
    @Expose
    private Object sortPointDistance;
    @SerializedName("employer")
    @Expose
    private Employer employer;
    @SerializedName("published_at")
    @Expose
    private String publishedAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("archived")
    @Expose
    private Boolean archived;
    @SerializedName("apply_alternate_url")
    @Expose
    private String applyAlternateUrl;
    @SerializedName("insider_interview")
    @Expose
    private Object insiderInterview;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("alternate_url")
    @Expose
    private String alternateUrl;
    @SerializedName("relations")
    @Expose
    private List<Object> relations = new ArrayList<Object>();
    @SerializedName("snippet")
    @Expose
    private Snippet snippet;
    @SerializedName("contacts")
    @Expose
    private Object contacts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getDepartment() {
        return department;
    }

    public void setDepartment(Object department) {
        this.department = department;
    }

    public Boolean getHasTest() {
        return hasTest;
    }

    public void setHasTest(Boolean hasTest) {
        this.hasTest = hasTest;
    }

    public Boolean getResponseLetterRequired() {
        return responseLetterRequired;
    }

    public void setResponseLetterRequired(Boolean responseLetterRequired) {
        this.responseLetterRequired = responseLetterRequired;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Object getResponseUrl() {
        return responseUrl;
    }

    public void setResponseUrl(Object responseUrl) {
        this.responseUrl = responseUrl;
    }

    public Object getSortPointDistance() {
        return sortPointDistance;
    }

    public void setSortPointDistance(Object sortPointDistance) {
        this.sortPointDistance = sortPointDistance;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public String getApplyAlternateUrl() {
        return applyAlternateUrl;
    }

    public void setApplyAlternateUrl(String applyAlternateUrl) {
        this.applyAlternateUrl = applyAlternateUrl;
    }

    public Object getInsiderInterview() {
        return insiderInterview;
    }

    public void setInsiderInterview(Object insiderInterview) {
        this.insiderInterview = insiderInterview;
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

    public List<Object> getRelations() {
        return relations;
    }

    public void setRelations(List<Object> relations) {
        this.relations = relations;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    public Object getContacts() {
        return contacts;
    }

    public void setContacts(Object contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("premium", premium).append("name", name).append("department", department).append("hasTest", hasTest).append("responseLetterRequired", responseLetterRequired).append("area", area).append("salary", salary).append("type", type).append("address", address).append("responseUrl", responseUrl).append("sortPointDistance", sortPointDistance).append("employer", employer).append("publishedAt", publishedAt).append("createdAt", createdAt).append("archived", archived).append("applyAlternateUrl", applyAlternateUrl).append("insiderInterview", insiderInterview).append("url", url).append("alternateUrl", alternateUrl).append("relations", relations).append("snippet", snippet).append("contacts", contacts).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(insiderInterview).append(sortPointDistance).append(department).append(premium).append(employer).append(snippet).append(type).append(url).append(contacts).append(publishedAt).append(id).append(area).append(alternateUrl).append(archived).append(relations).append(address).append(createdAt).append(applyAlternateUrl).append(name).append(responseUrl).append(responseLetterRequired).append(salary).append(hasTest).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Item) == false) {
            return false;
        }
        Item rhs = ((Item) other);
        return new EqualsBuilder().append(insiderInterview, rhs.insiderInterview).append(sortPointDistance, rhs.sortPointDistance).append(department, rhs.department).append(premium, rhs.premium).append(employer, rhs.employer).append(snippet, rhs.snippet).append(type, rhs.type).append(url, rhs.url).append(contacts, rhs.contacts).append(publishedAt, rhs.publishedAt).append(id, rhs.id).append(area, rhs.area).append(alternateUrl, rhs.alternateUrl).append(archived, rhs.archived).append(relations, rhs.relations).append(address, rhs.address).append(createdAt, rhs.createdAt).append(applyAlternateUrl, rhs.applyAlternateUrl).append(name, rhs.name).append(responseUrl, rhs.responseUrl).append(responseLetterRequired, rhs.responseLetterRequired).append(salary, rhs.salary).append(hasTest, rhs.hasTest).isEquals();
    }

}
