package ru.unic.hr.model.form;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by BritikovMI on 26.08.2019.
 */
public class Experience {
    private String value;
    private String text;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static List<Experience> getExperiences() {
        List<Experience> experiences = new LinkedList<>();

        Experience experienceFor = new Experience();
        experienceFor.setText("Без учета");
        experienceFor.setValue("");

        experiences.add(experienceFor);

        Experience experienceForm = new Experience();
        experienceForm.setText("Нет опыта");
        experienceForm.setValue("noExperience");

        experiences.add(experienceForm);

        Experience experienceForm1 = new Experience();
        experienceForm1.setText("От 1 года до 3 лет");
        experienceForm1.setValue("between1And3");

        experiences.add(experienceForm1);

        Experience experienceForm2 = new Experience();
        experienceForm2.setText("От 3 до 6 лет");
        experienceForm2.setValue("between3And6");

        experiences.add(experienceForm2);

        Experience experienceForm3 = new Experience();
        experienceForm3.setText("Более 6 лет");
        experienceForm3.setValue("moreThan6");

        experiences.add(experienceForm3);

        return experiences;
    }
}
