package ru.vsu.cs.dolzhenkoms.Tests;

import org.junit.Assert;
import org.junit.Test;
import ru.vsu.cs.dolzhenkoms.SpecialSymbols;

public class SpecialSymbolsTest {
    @Test
    public void checkEndpointSymbols() {
        Assert.assertTrue(SpecialSymbols.isSpecialEndpointSymbol('{'));
        Assert.assertTrue(SpecialSymbols.isSpecialEndpointSymbol('}'));
        Assert.assertTrue(SpecialSymbols.isSpecialEndpointSymbol('('));
        Assert.assertTrue(SpecialSymbols.isSpecialEndpointSymbol(')'));
        Assert.assertTrue(SpecialSymbols.isSpecialEndpointSymbol(','));
        Assert.assertTrue(SpecialSymbols.isSpecialEndpointSymbol('['));
        Assert.assertTrue(SpecialSymbols.isSpecialEndpointSymbol(']'));
        Assert.assertTrue(SpecialSymbols.isSpecialEndpointSymbol('\n'));
        Assert.assertTrue(SpecialSymbols.isSpecialEndpointSymbol(';'));
        Assert.assertFalse(SpecialSymbols.isSpecialEndpointSymbol('m'));
    }

    @Test
    public void checkJavaKeywords() {
        Assert.assertTrue(SpecialSymbols.isJavaKeyWordOrMain("private"));
        Assert.assertTrue(SpecialSymbols.isJavaKeyWordOrMain("class"));
        Assert.assertTrue(SpecialSymbols.isJavaKeyWordOrMain("throw"));
        Assert.assertTrue(SpecialSymbols.isJavaKeyWordOrMain("assert"));
        Assert.assertTrue(SpecialSymbols.isJavaKeyWordOrMain("int"));
        Assert.assertTrue(SpecialSymbols.isJavaKeyWordOrMain("String"));
        Assert.assertTrue(SpecialSymbols.isJavaKeyWordOrMain("main"));
        Assert.assertTrue(SpecialSymbols.isJavaKeyWordOrMain("Main"));
        Assert.assertTrue(SpecialSymbols.isJavaKeyWordOrMain("import"));
        Assert.assertFalse(SpecialSymbols.isJavaKeyWordOrMain("pRiVaTe"));
    }
}
