package ru.unic.hr.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.unic.hr.model.Item;
import ru.unic.hr.model.dictionary.Currency;
import ru.unic.hr.model.dictionary.Experience;
import ru.unic.hr.model.dictionary.SearchLabel;
import ru.unic.hr.model.dictionary.area.Area;
import ru.unic.hr.model.form.BasicForm;
import ru.unic.hr.service.builder.ReportingEngine;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ru.unic.hr.model.dictionary.Currency.getCurrenciesProperties;
import static ru.unic.hr.model.dictionary.Experience.getExperiencesProperties;
import static ru.unic.hr.model.dictionary.SearchLabel.getSearchLabelProperties;

/**
 * Created by BritikovMI on 21.08.2019.
 */
@Controller
public class CalculateVacancy {

    private String xlsxReportName = "xlsReport.xls";
    private List<Item> itemsFinal;

    @RequestMapping("/")
    public String vacancyController(Model model) {
        /*START BasicForm initialization*/
        BasicForm bf = BasicForm.basicFormInitilizer();
        String text = bf.getText();
        String area = bf.getArea();
        String salaryFrom = bf.getSalaryFrom();
        Integer perPage = bf.getPerPage();
        String experience = bf.getExperience();
        String currency = bf.getCurrency();
        String searchLabel = bf.getSearchLabel();
        /*END BasicForm initialization*/

        Map<ru.unic.hr.model.Model, Boolean> vacancyInfoMap = ru.unic.hr.model.Model.getVacancies(text, area, salaryFrom, perPage, 0, experience, currency, searchLabel); // Получаем базовую информацию по запросу

        Map.Entry<ru.unic.hr.model.Model, Boolean> entry = vacancyInfoMap.entrySet().iterator().next();
        ru.unic.hr.model.Model vacancyInfo = entry.getKey();
        Boolean isContainsVacancy = entry.getValue();

        Integer vacanciesFound = vacancyInfo.getFound();
        perPage = vacancyInfo.getPerPage();
        Integer pages = vacancyInfo.getPages();


        List<Item> items = new ArrayList<>();

        System.out.println("calculateVacancy");
        if (isContainsVacancy) { //Если по запросу пришли вакансии, то получаем
            System.out.println("МЫ тут в calculateVacancy");
            vacanciesFound = vacancyInfo.getFound();
            perPage = vacancyInfo.getPerPage();
            pages = vacancyInfo.getPages();
            items = Item.getItems(text, area, salaryFrom, experience, pages, perPage, currency, searchLabel);
        } else { //Если не пришли, то пока просто возвращаем базовое заполнение
            text = bf.getText();
            area = bf.getArea();
            salaryFrom = bf.getSalaryFrom();
            experience = bf.getExperience();
            currency = bf.getCurrency();
            searchLabel = bf.getSearchLabel();
            vacancyInfo = ru.unic.hr.model.Model.getVacancies(text, area, salaryFrom, perPage, 0, experience, currency, searchLabel).entrySet().iterator().next().getKey(); // Получаем базовую информацию по запросу
            perPage = vacancyInfo.getPerPage();
            pages = vacancyInfo.getPages();
            vacanciesFound = vacancyInfo.getFound();
            items = Item.getItems(text, area, salaryFrom, experience, pages, perPage, currency, searchLabel);
        }

        List<Integer> analysisData = DataAnalysis.takeDataForAnalysis(items);

        Integer avgSalary = DataAnalysis.analysisAvgSalary(analysisData);

        itemsFinal = items.parallelStream()
                .filter(sal -> sal.getSalary() != null && sal.getSalary().getFrom() != null)
                .sorted(Item.compareBySalary.reversed())
                .collect(Collectors.toList());


        List<Experience> experiencesProperties = getExperiencesProperties();
        List<Currency> currenciesProperties = getCurrenciesProperties();
        List<SearchLabel> searchLabelProperties = getSearchLabelProperties();

        model.addAttribute("experiences", experiencesProperties);
        model.addAttribute("areas", Area.areaGetter(Area.getModel()));
        model.addAttribute("currencies", currenciesProperties);
        model.addAttribute("resume_search_labeles", searchLabelProperties);
        model.addAttribute("maxSalary", (itemsFinal.get(0) != null && itemsFinal.get(0).getSalary() != null) ? itemsFinal.get(0).getSalary().getFrom() : "");
        model.addAttribute("requestName", text);
        model.addAttribute("avgSalary", avgSalary);
        model.addAttribute("vacancies", vacanciesFound);
        model.addAttribute("items", itemsFinal.subList(0, 20));
        return "db";
    }

    @GetMapping("/downloadXLSXReport")
    public void download(HttpServletResponse response) throws Exception {
       Workbook workbook = new HSSFWorkbook();

       workbook =  ReportingEngine.getXLSXWorkbookItemsReport(itemsFinal);

        response.setHeader("Content-disposition", "attachment; filename=" + xlsxReportName);
        workbook.write(response.getOutputStream());
    }

}
