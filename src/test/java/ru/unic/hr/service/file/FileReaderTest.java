package ru.unic.hr.service.file;

import java.io.File;

/**
 * Created by BritikovMI on 11.09.2019.
 */
public class FileReaderTest {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\BritikovMI\\Desktop\\msft.txt");

        System.out.println(FileReader.getFileContent(file));
    }

}