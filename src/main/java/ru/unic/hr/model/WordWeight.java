package ru.unic.hr.model;

import java.util.Comparator;

/**
 * Created by BritikovMI on 11.09.2019.
 */
public class WordWeight {
    private String word;
    private Integer counts;
    private Double weight;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public static Comparator<WordWeight> compareByCounts = Comparator.comparing(WordWeight::getCounts);

}
