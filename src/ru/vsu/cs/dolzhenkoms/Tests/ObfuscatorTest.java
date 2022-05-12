package ru.vsu.cs.dolzhenkoms.Tests;

import org.junit.jupiter.api.Assertions;
import ru.vsu.cs.dolzhenkoms.FileUtils;
import ru.vsu.cs.dolzhenkoms.Obfuscator;

import java.io.IOException;

class ObfuscatorTest {
    private Obfuscator obfuscator;

    @org.junit.jupiter.api.Test
    public void emptyFileObfuscatorTest() throws IOException {
        obfuscator = new Obfuscator("src/ru/vsu/cs/dolzhenkoms/Tests/Cases/Empty.txt");
        obfuscator.execute();

        String fileText = FileUtils.getAllText("ObfuscatedEmpty.txt");
        Assertions.assertEquals("", fileText, "Assert");
    }

    @org.junit.jupiter.api.Test
    public void normalFileObfuscatorTest() throws IOException {
        obfuscator = new Obfuscator("src/ru/vsu/cs/dolzhenkoms/Tests/Cases/SimpleJavaClass.txt");
        obfuscator.execute();

        String fileText = FileUtils.getAllText("ObfuscatedSimpleJavaClass.txt");
        String expectedCode = FileUtils.getAllText("src/ru/vsu/cs/dolzhenkoms/Tests/Cases/ExpectedSimpleJavaClass.txt");
        Assertions.assertEquals(expectedCode, fileText, "Assert");
    }
}
