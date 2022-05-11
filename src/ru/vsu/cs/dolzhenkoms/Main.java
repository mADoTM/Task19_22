package ru.vsu.cs.dolzhenkoms;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String filePath = "src/ru/vsu/cs/dolzhenkoms/SimpleBinaryTree.java";
        Obfuscator obfuscator = new Obfuscator(filePath);
        obfuscator.execute();
    }
}
