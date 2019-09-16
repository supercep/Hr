package ru.unic.hr.service.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by BritikovMI on 11.09.2019.
 */
public class FileReader {
    private static List<String> FORMATS = Arrays.asList("pdf", "txt", "doc", "docx");

    public static String getFile(File file) {
        StringBuilder fileContent = new StringBuilder();

        String fileExtension = getFileExtension(file);
        if (FORMATS.stream().anyMatch(xFormat -> xFormat.equals(fileExtension))) {
            try (Stream<String> stream = Files.lines(Paths.get(file.toString()))) {
                stream
                        .forEach(fileContent::append);

            } catch (IOException e) {
                System.out.println("Файл неверен или его нет! " +
                        "Ошибка: " + e);
            }
        } else {
            System.out.println("Формат файла не поддерживается!");
        }

        return fileContent.toString();

    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        else return "";
    }
}
