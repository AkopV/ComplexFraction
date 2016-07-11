package com.vardanian.complexFraction;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ComplexFractionTest {
    ComplexFraction complexFraction = new ComplexFraction(new ComplexNumber(2, 5), new ComplexNumber(4, 8));
    ComplexFraction complexFraction1 = new ComplexFraction(new ComplexNumber(1, 5), new ComplexNumber(2, 3));

    @Test
    public void testDivide() {
        Assert.assertEquals(complexFraction.divide(complexFraction1).equals(new ComplexFraction(complexFraction.getNumerator().multiply(complexFraction1.getDenominator()),
                complexFraction.getDenominator().multiply(complexFraction1.getNumerator()))), true);
    }

    @Test
    public void testMultiply() {
        Assert.assertEquals(complexFraction.multiply(complexFraction1).equals(new ComplexFraction(complexFraction.getNumerator().multiply(complexFraction1.getNumerator()),
                complexFraction.getDenominator().multiply(complexFraction1.getDenominator()))), true);
    }

    @Test
    public void testAdd(){
        Assert.assertEquals(complexFraction.add(complexFraction1).equals(new ComplexFraction(complexFraction.getNumerator().multiply(complexFraction1.getDenominator()).
                add(complexFraction.getDenominator().multiply(complexFraction1.getNumerator())),
                complexFraction.getDenominator().multiply(complexFraction1.getDenominator()))), true);
    }

    @Test
    public void testSubstract() {
        Assert.assertEquals(complexFraction.subtract(complexFraction1).equals(new ComplexFraction(complexFraction.getNumerator().multiply(complexFraction1.getDenominator()).
                subtract(complexFraction.getDenominator().multiply(complexFraction1.getNumerator())),
                complexFraction.getDenominator().multiply(complexFraction1.getDenominator()))), true);
    }
}
