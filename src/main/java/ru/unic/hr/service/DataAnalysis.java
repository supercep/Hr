package ru.unic.hr.service;

import ru.unic.hr.model.Item;
import ru.unic.hr.model.Salary;
import ru.unic.hr.service.loader.VacancyLoader;
import ru.unic.hr.service.parser.VacancyParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BritikovMI on 23.08.2019.
 */
public class DataAnalysis {
    public static List<Integer> takeDataForAnalysis(List<Item> data) {
        List<Integer> startSalary = new ArrayList<>();
        data.stream()
                .filter(sal -> sal.getSalary() != null && sal.getSalary().getFrom() != null)
                .forEach(salary -> {
                    Salary sal = salary.getSalary();
                    Integer from = sal.getFrom();
                    Integer to;
                    Integer finallySum;
                    if (sal.getTo() != null && sal.getTo() != null) {
                        to = sal.getTo();
                        finallySum = (from + to) / 2;
                    } else
                        finallySum = from;
                    startSalary.add(finallySum);
                });
        return startSalary;
    }

    public static Integer analysisAvgSalary(List<Integer> data) {
        Integer sizeOfSalaryList = data.size();
        Integer salarySum = null;

        salarySum = data.stream().mapToInt(Integer::intValue).sum();

        return (sizeOfSalaryList != 0) ? salarySum / sizeOfSalaryList : 0;
    }

    public static Integer getTop20(List<Integer> data) {
        Integer sizeOfSalaryList = data.size();
        Integer salarySum = null;

        salarySum = data.stream().mapToInt(Integer::intValue).sum();

        return (sizeOfSalaryList != 0) ? salarySum / sizeOfSalaryList : 0;
    }
}
