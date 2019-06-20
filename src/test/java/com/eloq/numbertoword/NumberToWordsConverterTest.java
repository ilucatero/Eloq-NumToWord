package com.eloq.numbertoword;

import org.junit.Assert;
import org.junit.Test;

public class NumberToWordsConverterTest {

    @Test
    public void convert() {
        String zeroWord = NumberToWordsConverter.convert(0);
        Assert.assertEquals("zero", zeroWord.toLowerCase());
    }
}