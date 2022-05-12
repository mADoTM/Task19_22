package ru.vsu.cs.dolzhenkoms;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class SpecialSymbols {
    private final static List<Character> symbols = Arrays.asList(
            '{', '}', ';', ',', '\n', '(', ')', '=', '[', ']', '>', '<', '&', '|', ' '
    );

    private final static List<String> javaKeywords = Arrays.asList(
    "abstract",	"continue",	"for",	"new",	"switch",
            "assert",	"default",	"goto",	"package",	"synchronized",
    "boolean",	"do",	"if",	"private",	"this",
            "break",	"double",	"implements",	"protected",	"throw",
    "byte",	"else",	"import",	"public",	"throws",
            "case",	"enum",	"instanceof",	"return",	"transient",
            "catch",	"extends",	"int",	"short",	"try",
            "char",	"final",	"interface",	"static",	"void",
            "class",	"finally",	"long",	"strictfp",	"volatile",
            "const",	"float",	"native",	"super",	"while", "String",
            "main", "Main"
    );

    public static boolean isJavaKeyWordOrMain(String word) {
        return javaKeywords.contains(word);
    }

    public static boolean isSpecialEndpointSymbol(char symbol) {
        return symbols.contains(symbol);
    }
}
