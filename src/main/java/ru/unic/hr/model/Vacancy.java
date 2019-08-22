package ru.unic.hr.model;

import ru.unic.hr.model.dictionary.entry.IDictionaryEntry;


public class Vacancy implements IDictionaryEntry {

    private String id;
    private String name;

    //TODO: add more atributes


    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean isNull() {
        return false;
    }
}



/*{
  "items": [
    {
      "id": "33002661",
      "premium": false,
      "name": "Менеджер по оценке звонков/Супервайзер-контролер call-центра",
      "department": null,
      "has_test": false,
      "response_letter_required": false,
      "area": {
        "id": "1",
        "name": "Москва",
        "builder": "https://api.hh.ru/areas/1"
      },
      "salary": {
        "from": 12000,
        "to": 15000,
        "currency": "RUR",
        "gross": false
      },
      "type": {
        "id": "open",
        "name": "Открытая"
      },
      "address": null,
      "response_url": null,
      "sort_point_distance": null,
      "employer": {
        "id": "1660293",
        "name": "HOBBI Smoke (Данилов А.Г.)",
        "builder": "https://api.hh.ru/employers/1660293",
        "alternate_url": "https://hh.ru/employer/1660293",
        "logo_urls": {
          "90": "https://hhcdn.ru/employer-logo/2060086.png",
          "original": "https://hhcdn.ru/employer-logo-original/404502.png",
          "240": "https://hhcdn.ru/employer-logo/2060087.png"
        },
        "vacancies_url": "https://api.hh.ru/vacancies?employer_id=1660293",
        "trusted": true
      },
      "published_at": "2019-08-13T13:58:19+0300",
      "created_at": "2019-08-13T13:58:19+0300",
      "archived": false,
      "apply_alternate_url": "https://hh.ru/applicant/vacancy_response?vacancyId=33002661",
      "insider_interview": null,
      "builder": "https://api.hh.ru/vacancies/33002661?host=hh.ru",
      "alternate_url": "https://hh.ru/vacancy/33002661",
      "relations": [],
      "snippet": {
        "requirement": "Наличие компьютера и интернета. Уверенный пользователь ПК. Адекватность.",
        "responsibility": "Прослушивать звонки менеджеров по продажам. Оценивать звонки по чек-листам. Заполнять отчет (таблицу). В неделю надо прослушать 100-130 звонков."
      },
      "contacts": null
    }
  ],
  "found": 713934,
  "pages": 100,
  "per_page": 20,
  "page": 0,
  "clusters": null,
  "arguments": null,
  "alternate_url": "https://hh.ru/search/vacancy?enable_snippets=true"
}*/