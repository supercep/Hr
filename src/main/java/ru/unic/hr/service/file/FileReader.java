package ru.unic.hr.service.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by BritikovMI on 11.09.2019.
 */
public class FileReader {
    private static List<String> FORMATS_WHITELIST = Arrays.asList("pdf", "txt", "doc", "docx");

    public static String getFileContent(File file) {
        String fileContent = "";
        if (file.exists() && FileReader.checkFile(file)) {
            try {
                fileContent = String.join(" ", Files.readAllLines(Paths.get(file.getAbsolutePath())));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
            System.out.println("Формат файла не поддерживается!");
        return fileContent;
    }

    private static Boolean checkFile(File file) {
        String fileExtension = getFileExtension(file);
        return FORMATS_WHITELIST.stream().anyMatch(fmt -> fmt.equalsIgnoreCase(fileExtension));
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        else return "";
    }
}
