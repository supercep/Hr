package ru.unic.hr;

import org.junit.Test;
import ru.unic.hr.model.Vacancy;
import ru.unic.hr.service.parser.VacancyParser;

/**
 * Created by BritikovMI on 16.08.2019.
 */


public class TestParse {
    @Test
    public void testParse(){
        VacancyParser parser = new VacancyParser();
        Vacancy vacancy = parser.parse(text);

        System.out.println(vacancy.getId() + " " + vacancy.getName());
    }


    private static String text = "{\n" +
            "  \"items\": [\n" +
            "    {\n" +
            "      \"id\": \"33002661\",\n" +
            "      \"premium\": false,\n" +
            "      \"name\": \"Менеджер по оценке звонков/Супервайзер-контролер call-центра\",\n" +
            "      \"department\": null,\n" +
            "      \"has_test\": false,\n" +
            "      \"response_letter_required\": false,\n" +
            "      \"area\": {\n" +
            "        \"id\": \"1\",\n" +
            "        \"name\": \"Москва\",\n" +
            "        \"url\": \"https://api.hh.ru/areas/1\"\n" +
            "      },\n" +
            "      \"salary\": {\n" +
            "        \"from\": 12000,\n" +
            "        \"to\": 15000,\n" +
            "        \"currency\": \"RUR\",\n" +
            "        \"gross\": false\n" +
            "      },\n" +
            "      \"type\": {\n" +
            "        \"id\": \"open\",\n" +
            "        \"name\": \"Открытая\"\n" +
            "      },\n" +
            "      \"address\": null,\n" +
            "      \"response_url\": null,\n" +
            "      \"sort_point_distance\": null,\n" +
            "      \"employer\": {\n" +
            "        \"id\": \"1660293\",\n" +
            "        \"name\": \"HOBBI Smoke (Данилов А.Г.)\",\n" +
            "        \"url\": \"https://api.hh.ru/employers/1660293\",\n" +
            "        \"alternate_url\": \"https://hh.ru/employer/1660293\",\n" +
            "        \"logo_urls\": {\n" +
            "          \"90\": \"https://hhcdn.ru/employer-logo/2060086.png\",\n" +
            "          \"original\": \"https://hhcdn.ru/employer-logo-original/404502.png\",\n" +
            "          \"240\": \"https://hhcdn.ru/employer-logo/2060087.png\"\n" +
            "        },\n" +
            "        \"vacancies_url\": \"https://api.hh.ru/vacancies?employer_id=1660293\",\n" +
            "        \"trusted\": true\n" +
            "      },\n" +
            "      \"published_at\": \"2019-08-13T13:58:19+0300\",\n" +
            "      \"created_at\": \"2019-08-13T13:58:19+0300\",\n" +
            "      \"archived\": false,\n" +
            "      \"apply_alternate_url\": \"https://hh.ru/applicant/vacancy_response?vacancyId=33002661\",\n" +
            "      \"insider_interview\": null,\n" +
            "      \"url\": \"https://api.hh.ru/vacancies/33002661?host=hh.ru\",\n" +
            "      \"alternate_url\": \"https://hh.ru/vacancy/33002661\",\n" +
            "      \"relations\": [],\n" +
            "      \"snippet\": {\n" +
            "        \"requirement\": \"Наличие компьютера и интернета. Уверенный пользователь ПК. Адекватность.\",\n" +
            "        \"responsibility\": \"Прослушивать звонки менеджеров по продажам. Оценивать звонки по чек-листам. Заполнять отчет (таблицу). В неделю надо прослушать 100-130 звонков.\"\n" +
            "      },\n" +
            "      \"contacts\": null\n" +
            "    }\n" +
            "  ],\n" +
            "  \"found\": 713934,\n" +
            "  \"pages\": 100,\n" +
            "  \"per_page\": 20,\n" +
            "  \"page\": 0,\n" +
            "  \"clusters\": null,\n" +
            "  \"arguments\": null,\n" +
            "  \"alternate_url\": \"https://hh.ru/search/vacancy?enable_snippets=true\"\n" +
            "}";
}





