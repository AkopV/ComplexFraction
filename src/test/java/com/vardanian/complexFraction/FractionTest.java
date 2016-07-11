package com.vardanian.complexFraction;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FractionTest {

    Fraction fraction = new Fraction(4, 3);

    Fraction doFraction1 = new Fraction(5, 6);

    @Test
    public void testDivide() {
        Assert.assertEquals(fraction.divide(doFraction1).equals(new Fraction(fraction.getNumen() * doFraction1.getDenom(), fraction.getDenom() * doFraction1.getNumen())), true);
    }

    @Test
    public void testGetSimpleDoubleDivide() {
        Assert.assertEquals(Fraction.getSimpleDouble(fraction.divide(doFraction1)), 1.6D);
    }

    @Test
    public void testMultiply() {
        Assert.assertEquals(fraction.multiply(doFraction1).equals(new Fraction(fraction.getNumen() * doFraction1.getNumen(), fraction.getDenom() * doFraction1.getDenom())), true);
    }

    @Test
    public void testGetSimpleDoubleMultiply() {
        Assert.assertEquals(Fraction.getSimpleDouble(fraction.multiply(doFraction1)), 1.1111111111111112D);
    }

    @Test
    public void testAdd() {
        Assert.assertEquals(fraction.add(doFraction1).equals(new Fraction(fraction.getNumen() * doFraction1.getDenom() + doFraction1.getNumen() * fraction.getDenom(),
                fraction.getDenom() * doFraction1.getDenom())), true);
    }

    @Test
    public void testGetSimpleDoubleAdd() {
        Assert.assertEquals(Fraction.getSimpleDouble(fraction.add(doFraction1)), 2.16666666666666666D);
    }

    @Test
    public void testSubstract() {
        Assert.assertEquals(fraction.substract(doFraction1).equals(new Fraction(fraction.getNumen() * doFraction1.getDenom() - doFraction1.getNumen() * fraction.getDenom(),
                fraction.getDenom() * doFraction1.getDenom())), true);
    }

    @Test
    public void testGetSimpleDoubleSubstract() {
        Assert.assertEquals(Fraction.getSimpleDouble(fraction.substract(doFraction1)), 0.5D);
    }

    @Test
    public void testRoundResult() {
        Assert.assertEquals(Fraction.roundResult(4.25484521), 4.25);
    }
}