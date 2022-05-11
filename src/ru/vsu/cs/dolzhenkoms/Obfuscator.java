package ru.vsu.cs.dolzhenkoms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Obfuscator {
    private HashMap<String, String> obfuscateDictionary = new HashMap<String, String>();

    private String javaFileSource;

    public Obfuscator(String source) {
        this.javaFileSource = source;
    }

    public void execute() throws IOException {
        String code = FileUtils.getAllText(javaFileSource).trim().replace("\r", " ").replace("\n \n", "\n");

        System.out.println(code);

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
                else if(word.length() == 1 && SpecialSymbols.isSpecialEndpointSymbol(word.charAt(0))) {
                        obfuscateCode.append(word);
                }
                else if (SpecialSymbols.isJavaKeyWordOrMain(word)) {
                    obfuscateCode.append(word);
                }
                else {
                    if(word.charAt(0) == '\"') {
                        if (word.charAt(word.length() - 1) == '\"') {
                            obfuscateCode.append(word);
                        }
                        else {
                            continue;
                        }
                    }
                    else if(!obfuscateDictionary.containsKey(word)) {
                        String temp = "v" + (obfuscateDictionary.size() + 1);
                        obfuscateDictionary.put(word, temp);
                        obfuscateCode.append(temp);
                    }
                    else {
                        obfuscateCode.append(obfuscateDictionary.get(word));
                    }
                }
                lastIndex = i + 1;
                obfuscateCode.append(symbol);
            }
        }
        System.out.println(obfuscateCode.toString());
    }
}
