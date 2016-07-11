package com.vardanian.complexFraction;

public class ComplexFraction extends Fraction {
    ComplexNumber numerator;
    ComplexNumber denominator;

    public ComplexFraction(ComplexNumber numerator, ComplexNumber denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public ComplexNumber getNumerator() {
        return numerator;
    }

    public void setNumerator(ComplexNumber numerator) {
        this.numerator = numerator;
    }

    public ComplexNumber getDenominator() {
        return denominator;
    }

    public void setDenominator(ComplexNumber denominator) {
        this.denominator = denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ComplexFraction)) {
            return false;
        }
        ComplexFraction complexFraction = (ComplexFraction) obj;
        return complexFraction.getNumerator().equals(numerator) & complexFraction.getDenominator().equals(denominator);
    }

    @Override
    public String toString() {
        return "ComplexFraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }

    public ComplexFraction multiply(ComplexFraction t) {
        return new ComplexFraction(this.numerator.multiply(t.numerator), this.denominator.multiply(t.denominator));
    }

    public ComplexFraction divide(ComplexFraction t) {
        return new ComplexFraction(this.numerator.multiply(t.denominator), this.denominator.multiply(t.numerator));
    }

    public ComplexFraction add(ComplexFraction t) {
        return new ComplexFraction(this.numerator.multiply(t.denominator).add(this.denominator.multiply(t.numerator)), this.denominator.multiply(t.denominator));
    }

    public ComplexFraction subtract(ComplexFraction t) {
        return new ComplexFraction(this.numerator.multiply(t.denominator).subtract(this.denominator.multiply(t.numerator)), this.denominator.multiply(t.denominator));
    }

    public static ComplexNumber getSimpleComplexNumber(ComplexFraction complexDrobi) {
        return complexDrobi.numerator.divide(complexDrobi.denominator);
    }

    public static void main(String[] args) {
        ComplexFraction complexFraction = new ComplexFraction(new ComplexNumber(2, 5), new ComplexNumber(4, 8));
        ComplexFraction complexFraction1 = new ComplexFraction(new ComplexNumber(1, 5), new ComplexNumber(2, 3));
        System.out.println(complexFraction.multiply(complexFraction1) + " convert to complex number -> " + getSimpleComplexNumber(complexFraction.multiply(complexFraction1)));
        System.out.println(complexFraction.divide(complexFraction1) + " convert to complex number -> " + getSimpleComplexNumber(complexFraction.divide(complexFraction1)));
        System.out.println(complexFraction.add(complexFraction1) + " convert to complex number -> " + getSimpleComplexNumber(complexFraction.add(complexFraction1)));
        System.out.println(complexFraction.subtract(complexFraction1) + " convert to complex number -> " + getSimpleComplexNumber(complexFraction.subtract(complexFraction1)));

        System.out.println(complexFraction.multiply(complexFraction1).equals(
                new ComplexFraction(complexFraction.numerator.multiply(complexFraction1.numerator),
                        complexFraction.denominator.multiply(complexFraction1.denominator))));

        System.out.println(complexFraction.subtract(complexFraction1).equals(new ComplexFraction(complexFraction.getNumerator().multiply(complexFraction1.getDenominator()).
                subtract(complexFraction.getDenominator().multiply(complexFraction1.getNumerator())),
                complexFraction.getDenominator().multiply(complexFraction1.getDenominator()))));
    }
}
