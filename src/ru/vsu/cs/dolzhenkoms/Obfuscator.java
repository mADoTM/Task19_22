package ru.vsu.cs.dolzhenkoms;

import java.io.IOException;
import java.util.HashMap;
public class Obfuscator {
    private HashMap<String, String> obfuscateDictionary = new HashMap<>();

    private final String javaFileSource;
    private final String code;

    public Obfuscator(String source) throws IOException {
        this.javaFileSource = source;
        this.code = FileUtils.getAllText(javaFileSource);
    }

    public void execute() throws IOException {
        StringBuilder obfuscateCode = new StringBuilder();

        int lastIndex = 0;
        for (int i = 0; i < code.length(); i++) {
            char symbol = code.charAt(i);
            if (SpecialSymbols.isSpecialEndpointSymbol(symbol)) {
                String word = code.substring(lastIndex, i);
                if(word.length() == 0) {
                    lastIndex = i + 1;
                    obfuscateCode.append(symbol);
                    continue;
                }
                else if(isWordSpecial(word) || isWordNumber(word)) {
                        obfuscateCode.append(word);
                }
                else {
                    if(word.charAt(0) == '\"') {
                        if (isWordString(word)) {
                            obfuscateCode.append(word);
                        }
                        else {
                            continue;
                        }
                    }
                    else if(obfuscateDictionary.containsKey(word)) {
                        obfuscateCode.append(obfuscateDictionary.get(word));

                    }
                    else {
                        String temp = "v" + (obfuscateDictionary.size() + 1);
                        obfuscateDictionary.put(word, temp);
                        obfuscateCode.append(temp);
                    }
                }
                lastIndex = i + 1;
                obfuscateCode.append(symbol);
            }
        }

        String obfuscatedFileName = "Obfuscated" + getFileName();
        FileUtils.createFileWithText(obfuscatedFileName, obfuscateCode.toString());
    }

    private String getFileName() {
        String[] details = javaFileSource.split("/");
        return details[details.length - 1];
    }

    private boolean isWordString(String word) {
        return word.charAt(0) == '\"' && word.charAt(word.length() - 1) == '\"';
    }

    private boolean isWordSpecial(String word) {
        return word.length() == 1 && SpecialSymbols.isSpecialEndpointSymbol(word.charAt(0)) || SpecialSymbols.isJavaKeyWordOrMain(word);
    }

    private boolean isWordNumber(String word) {
        if (word == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(word);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
