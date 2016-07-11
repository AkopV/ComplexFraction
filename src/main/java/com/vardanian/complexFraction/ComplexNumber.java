package com.vardanian.complexFraction;

public class ComplexNumber {
    private int realNum;
    private int imageNum;

    public ComplexNumber(int realNum, int imaginaryNum) {
        this.realNum = realNum;
        this.imageNum = imaginaryNum;
    }

    @Override
    public String toString() {
        if (imageNum == 0) {
            return realNum + "";

        }
        if (realNum == 0) {
            return imageNum + "i";
        }
        if (imageNum < 0) {
            return realNum + " - " + (-imageNum) + "i";
        }
        return "ComplexNumber{" +
                "realNum=" + realNum +
                ", imageNum=" + imageNum +
                "i" + '}';
    }

    public int getImageNum() {
        return imageNum;
    }

    public void setImageNum(int imageNum) {
        this.imageNum = imageNum;
    }

    public int getRealNum() {
        return realNum;
    }

    public void setRealNum(int realNum) {
        this.realNum = realNum;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ComplexNumber))
            return false;
        ComplexNumber complexNumber = (ComplexNumber) obj;
        return complexNumber.getRealNum() == realNum && complexNumber.getImageNum() == imageNum;
    }

    public ComplexNumber add(ComplexNumber complexNumber) {
        return new ComplexNumber(this.realNum + complexNumber.realNum, this.imageNum + complexNumber.imageNum);
    }

    public ComplexNumber subtract(ComplexNumber complexNumber) {
        return new ComplexNumber(this.realNum - complexNumber.realNum, this.imageNum - complexNumber.imageNum);
    }

    public ComplexNumber multiply(ComplexNumber complexNumber) {
        return new ComplexNumber(this.realNum * complexNumber.realNum - this.imageNum * complexNumber.imageNum,
                this.realNum * complexNumber.imageNum + this.imageNum * complexNumber.realNum);
    }

    public ComplexNumber divide(ComplexNumber complexNumber) {

        return new ComplexNumber((this.realNum * complexNumber.realNum + this.imageNum * complexNumber.imageNum) / (complexNumber.realNum * complexNumber.realNum + complexNumber.imageNum * complexNumber.imageNum),
                (complexNumber.realNum * this.imageNum - this.realNum * complexNumber.imageNum) / (complexNumber.realNum * complexNumber.realNum + complexNumber.imageNum * complexNumber.imageNum));
    }

    public static void main(String[] args) {

        ComplexNumber complexNumber = new ComplexNumber(1, 2);
        ComplexNumber complexNumber1 = new ComplexNumber(1, 3);

        System.out.println(complexNumber.add(complexNumber1));
        System.out.println(complexNumber.subtract(complexNumber1));
        System.out.println(complexNumber.multiply(complexNumber1));
        System.out.println(complexNumber.divide(complexNumber1));
    }
}
