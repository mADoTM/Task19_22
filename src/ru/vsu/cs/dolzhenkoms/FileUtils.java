package ru.vsu.cs.dolzhenkoms;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {
    public static String getAllText(String path) throws IOException {
        String text = Files.readString(Paths.get(path), StandardCharsets.UTF_8);

        return text;
    }
}
