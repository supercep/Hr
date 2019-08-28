
package ru.unic.hr.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import ru.unic.hr.service.loader.VacancyLoader;
import ru.unic.hr.service.parser.VacancyParser;

public class Model {

    @SerializedName("items")
    @Expose
    private List<Item> items = new ArrayList<Item>();
    @SerializedName("found")
    @Expose
    private Integer found;
    @SerializedName("pages")
    @Expose
    private Integer pages;
    @SerializedName("per_page")
    @Expose
    private Integer perPage;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("clusters")
    @Expose
    private Object clusters;
    @SerializedName("arguments")
    @Expose
    private Object arguments;
    @SerializedName("alternate_url")
    @Expose
    private String alternateUrl;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Integer getFound() {
        return found;
    }

    public void setFound(Integer found) {
        this.found = found;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Object getClusters() {
        return clusters;
    }

    public void setClusters(Object clusters) {
        this.clusters = clusters;
    }

    public Object getArguments() {
        return arguments;
    }

    public void setArguments(Object arguments) {
        this.arguments = arguments;
    }

    public String getAlternateUrl() {
        return alternateUrl;
    }

    public void setAlternateUrl(String alternateUrl) {
        this.alternateUrl = alternateUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("items", items).append("found", found).append("pages", pages).append("perPage", perPage).append("page", page).append("clusters", clusters).append("arguments", arguments).append("alternateUrl", alternateUrl).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(arguments).append(alternateUrl).append(clusters).append(page).append(items).append(pages).append(perPage).append(found).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Model) == false) {
            return false;
        }
        Model rhs = ((Model) other);
        return new EqualsBuilder().append(arguments, rhs.arguments).append(alternateUrl, rhs.alternateUrl).append(clusters, rhs.clusters).append(page, rhs.page).append(items, rhs.items).append(pages, rhs.pages).append(perPage, rhs.perPage).append(found, rhs.found).isEquals();
    }

    public static Map<Model, Boolean> getVacancies(String text, String area, String salaryFrom, Integer perPage, Integer page, String experience, String currency, String search_label) {
        String content = VacancyLoader.load(text, area, salaryFrom, perPage, page, experience, currency, search_label);

        VacancyParser parser = new VacancyParser();
        Model vacancyModel = null;

        Map<Model, Boolean> modelContainsMap = new HashMap<>();
        if (content != null && !content.isEmpty() && !content.contains("bad argument")) {
            vacancyModel = parser.parse(content);
            modelContainsMap.put(vacancyModel, true);
        }else
            modelContainsMap.put(vacancyModel, false);

        return modelContainsMap;
    }

}
