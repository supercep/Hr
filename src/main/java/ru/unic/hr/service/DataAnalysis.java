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
                    startSalary.add(salary.getSalary().getFrom());
                });
        return startSalary;
    }

    public static Integer analysisAvgSalary(List<Integer> data) {
        Integer sizeOfSalaryList = data.size();
        Integer salarySum = null;

        salarySum = data.stream().mapToInt(Integer::intValue).sum();

        return (sizeOfSalaryList != 0) ? salarySum / sizeOfSalaryList : 0;
    }

    public static void main(String[] args) {
        String text = "java";
        String area = null;
        String salaryFrom = "";
        String content = VacancyLoader.load(text, area, salaryFrom);
        VacancyParser parser = new VacancyParser();
        ru.unic.hr.model.Model vacancyModel = null;
        List<Item> items = new ArrayList<>();

        if (content != null && !content.isEmpty()) {
            vacancyModel = parser.parse(content);
            items = vacancyModel.getItems();
        }

        List<Integer> analysisData = DataAnalysis.takeDataForAnalysis(items);

        Integer avgSalary = DataAnalysis.analysisAvgSalary(analysisData);
        System.out.println(avgSalary);
    }
}
