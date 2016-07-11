package com.vardanian.complexFraction;

public class Fraction {
    private int denom;
    private int numen;

    public Fraction() {

    }

    public Fraction(int denom, int numen) {
        this.denom = denom;
        this.numen = numen;
    }

    public int getDenom() {
        return denom;
    }

    public void setDenom(int denom) {
        this.denom = denom;
    }

    public int getNumen() {
        return numen;
    }

    public void setNumen(int numen) {
        this.numen = numen;
    }

    public Fraction divide(Fraction t) {
        return new Fraction(this.numen * t.denom, this.denom * t.numen);
    }

    public Fraction multiply(Fraction t) {
        return new Fraction(this.numen * t.numen, this.denom * t.denom);
    }

    public Fraction add(Fraction t) {
        return new Fraction(this.numen * t.denom + t.numen * this.denom, this.denom * t.denom);
    }

    public Fraction substract(Fraction t) {
        return new Fraction(this.numen * t.denom - t.numen * this.denom, this.denom * t.denom);
    }

    public static double getSimpleDouble(Fraction t) {
        return (double) t.numen / t.denom;
    }

    public static double roundResult(double result) {
        result = result * 100;
        int i = (int) Math.round(result);
        result = (double) i / 100;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(getClass() == obj.getClass())) {
            return false;
        } else {
            Fraction d = (Fraction) obj;
            return d.getNumen() == numen & d.getDenom() == denom;
        }
    }

    @Override
    public String toString() {
        return "{" + numen +
                "/" + denom +
                "}";
    }

    public static void main(String[] args) {
        Fraction fraction = new Fraction(4, 3);
        Fraction doFraction1 = new Fraction(5, 6);
        System.out.println(fraction + "/" + doFraction1 + "=" + fraction.divide(doFraction1) + "=" + getSimpleDouble(fraction.divide(doFraction1)));
        System.out.println(fraction + "*" + doFraction1 + "=" + fraction.multiply(doFraction1) + "=" + getSimpleDouble(fraction.multiply(doFraction1)));
        System.out.println(fraction + "+" + doFraction1 + "=" + fraction.add(doFraction1) + "=" + getSimpleDouble(fraction.add(doFraction1)));
        System.out.println(fraction + "-" + doFraction1 + "=" + fraction.substract(doFraction1) + "=" + getSimpleDouble(fraction.substract(doFraction1)));
        System.out.println(fraction.divide(doFraction1).equals(new Fraction(fraction.getNumen() * doFraction1.getDenom(), fraction.getDenom() * doFraction1.getNumen())));
    }
}
