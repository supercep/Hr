package ru.unic.hr.model.form;

/**
 * Created by BritikovMI on 27.08.2019.
 */
public class BasicForm {
    String text;
    String area;
    String salaryFrom;
    Integer perPage;
    String experience;
    String currency;
    String searchLabel;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSalaryFrom() {
        return salaryFrom;
    }

    public void setSalaryFrom(String salaryFrom) {
        this.salaryFrom = salaryFrom;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSearchLabel() {
        return searchLabel;
    }

    public void setSearchLabel(String searchLabel) {
        this.searchLabel = searchLabel;
    }

    public static BasicForm basicFormInitilizer() {
        BasicForm bf = new BasicForm();
        bf.setArea(null);
        bf.setSalaryFrom(null);
        bf.setSalaryFrom(null);
        bf.setPerPage(100);
        bf.setExperience(null);
        bf.setCurrency("RUR");
        bf.setSearchLabel("only_with_salary");

        return bf;
    }
}
