package com.eloq.numbertoword;

import org.junit.Assert;
import org.junit.Test;

public class NumberToWordsConverterENTest {

    @Test
    public void convertBelowTen() {
        String zeroWord = NumberToWordsConverterEN.convert(0);
        Assert.assertEquals("zero", zeroWord.toLowerCase());

        String Ones_1 = NumberToWordsConverterEN.convert(1);
        Assert.assertEquals("one", Ones_1.toLowerCase());
        String Ones_9 = NumberToWordsConverterEN.convert(9);
        Assert.assertEquals("nine", Ones_9.toLowerCase());
    }

    @Test
    public void convertTens() {
        String teens_10 = NumberToWordsConverterEN.convert(10);
        Assert.assertEquals("ten", teens_10.toLowerCase());
        String teens_15 = NumberToWordsConverterEN.convert(15);
        Assert.assertEquals("fifteen", teens_15.toLowerCase());
        String teens_20 = NumberToWordsConverterEN.convert(20);
        Assert.assertEquals("twenty", teens_20.toLowerCase());
        String teens_22 = NumberToWordsConverterEN.convert(23);
        Assert.assertEquals("twenty-three", teens_22.toLowerCase());
        String teens_90 = NumberToWordsConverterEN.convert(99);
        Assert.assertEquals("ninety-nine", teens_90.toLowerCase());
    }

    @Test
    public void convertHundreds() {
        String hundred_1 = NumberToWordsConverterEN.convert(115);
        Assert.assertEquals("one hundred fifteen", hundred_1 .toLowerCase());
        String hundred_2 = NumberToWordsConverterEN.convert(602);
        Assert.assertEquals("six hundred two", hundred_2.toLowerCase());
    }

    @Test
    public void convertThousands() {
        String thousand_1 = NumberToWordsConverterEN.convert(1015);
        Assert.assertEquals("one thousand fifteen", thousand_1 .toLowerCase());
        String thousand_2 = NumberToWordsConverterEN.convert(1602);
        Assert.assertEquals("one thousand six hundred two", thousand_2.toLowerCase());

        String thousandOne = NumberToWordsConverterEN.convert(48_320);
        Assert.assertEquals("forty-eight thousand three hundred twenty", thousandOne.toLowerCase());

        String thousandHundred = NumberToWordsConverterEN.convert(548_321);
        Assert.assertEquals("five hundred forty-eight thousand three hundred twenty-one", thousandHundred.toLowerCase());
    }

    @Test
    public void convertMullion() {
        String millionOne = NumberToWordsConverterEN.convert(1_048_321);
        Assert.assertEquals("one million forty-eight thousand three hundred twenty-one", millionOne.toLowerCase());

        String millionHundred = NumberToWordsConverterEN.convert(1_548_321);
        Assert.assertEquals("one million five hundred forty-eight thousand three hundred twenty-one", millionHundred.toLowerCase());
    }

    @Test
    public void convertBillion() {
        String billionOne = NumberToWordsConverterEN.convert(1_000_000_321);
        Assert.assertEquals("one billion three hundred twenty-one", billionOne.toLowerCase());

        String billionHundred = NumberToWordsConverterEN.convert(1_000_048_321);
        Assert.assertEquals("one billion forty-eight thousand three hundred twenty-one", billionHundred.toLowerCase());

        String billionMillionOne = NumberToWordsConverterEN.convert(1_001_048_321);
        Assert.assertEquals("one billion one million forty-eight thousand three hundred twenty-one", billionMillionOne.toLowerCase());

        String billionMillionHundred = NumberToWordsConverterEN.convert(1_201_048_321);
        Assert.assertEquals("one billion two hundred one million forty-eight thousand three hundred twenty-one", billionMillionHundred.toLowerCase());

        String billionTwo = NumberToWordsConverterEN.convert(2_000_000_000);
        Assert.assertEquals("two billion", billionTwo.toLowerCase());

        String billionLastAdmissibleValue = NumberToWordsConverterEN.convert(Integer.MAX_VALUE);
        Assert.assertEquals("two billion one hundred forty-seven million four hundred eighty-three thousand six hundred forty-seven", billionLastAdmissibleValue.toLowerCase());

    }

    @Test (expected = IllegalArgumentException.class)
    public void convertNonValid_negative() {
        NumberToWordsConverterEN.convert(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void convertNonValid_null() {
        NumberToWordsConverterEN.convert(null);
    }

}
