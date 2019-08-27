package ru.unic.hr.model.dictionary;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by BritikovMI on 27.08.2019.
 */
public enum  Currency {
    RUR("RUR", "руб.", "Рубли", 1.0, true), //Basic currencies with basic params
    BYR("BYR", "бел. руб.", "Белорусские рубли", 0.031175, false),
    EUR("EUR", "EUR", "Евро", 0.013625, true),
    USD("USD", "USD", "Доллары", 0.015158, true);

    private String code;
    private String abbr;
    private String name;
    private Double rate;
    private Boolean in_use;

    Currency(String code, String abbr, String name, Double rate, Boolean in_use) {
        this.code = code;
        this.abbr = abbr;
        this.name = name;
        this.rate = rate;
        this.in_use = in_use;
    }

    public static List<Currency> getCurrenciesProperties() {
        List<Currency> currencies = new LinkedList<>();

        currencies.add(Currency.RUR);

        currencies.add(Currency.BYR);

        currencies.add(Currency.EUR);

        currencies.add(Currency.USD);

        return currencies;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Boolean getIn_use() {
        return in_use;
    }

    public void setIn_use(Boolean in_use) {
        this.in_use = in_use;
    }
}
