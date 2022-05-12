package ru.vsu.cs.dolzhenkoms;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {
    public static String getAllText(String path) throws IOException {
        String text = Files.readString(Paths.get(path), StandardCharsets.UTF_8);

        return text;
    }

    public static void createFileWithText(String filePath, String text) throws IOException {
        if(isFileExist(filePath))
            return;

        File file = new File(filePath);
        file.createNewFile();

        FileWriter fw = new FileWriter(file);
        fw.write(text);
        fw.close();
    }

    public static boolean isFileExist(String filePath) {
        if(filePath == null)
            return false;
        return (new File(filePath)).exists();
    }
}
