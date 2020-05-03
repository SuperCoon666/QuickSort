package com.company;
import java.lang.Math;

public class Fraction implements Comparable<Fraction> {
    private int a, b;
    Fraction(){
        this.a = 0;
        this.b = 1;
    }
    Fraction(int a, int b){
        if (b == 0){
            throw new NullPointerException("\n" + "Исключение деление на ноль");
        }
        this.a = a;
        this.b = b;
    }
    Fraction copy(){
        return new Fraction(this.a, this.b);
    }




    Fraction add(Fraction f2){
        Fraction f = new Fraction(this.a * f2.getB() + f2.getA() * this.b, this.b * f2.getB());
        f.reducation();
        return f;
    }

    Fraction subtract(Fraction f2){
        Fraction f = new Fraction(this.a * f2.getB() - f2.getA() * this.b, this.b * f2.getB());
        f.reducation();
        return f;
    }

    Fraction multiply(Fraction f2){
        Fraction f = new Fraction(this.a * f2.getA(), this.b * f2.getB());
        f.reducation();
        return f;
    }

    Fraction divide(Fraction f2){
        if (f2.getA() == 0){
            throw new NullPointerException("Исключение деление на ноль");
        }
        Fraction f = new Fraction(this.a * f2.getB(), this.b * f2.getA());
        f.reducation();
        return f;
    }

    void reducation(){

        boolean minus = false;
        if (this.a < 0){
            this.a = -this.a;
            minus = !minus;
        }
        if (this.b < 0){
            this.b = -this.b;
            minus = !minus;
        }
        int a = this.a, b = this.b;
        while (b != 0 && a != 0){
            if (a > b){
                a %= b;
            }
            else{
                b %= a;
            }
        }
        if (minus) this.a = -(this.a / (a + b));
        else this.a /= (a + b);
        this.b /= a + b;
    }

    Fraction abs(){
        return new Fraction((this.a > 0)?a:-a, (this.b > 0)?b:-b);
    }

    static boolean equals(Fraction z1, Fraction z2){
        Fraction z3 = new Fraction(z1.getA(), z1.getB());
        Fraction z4 = new Fraction(z2.getA(), z2.getB());
        z3.reducation();
        z4.reducation();
        if (z3.getA() == z4.getA() && z3.getB() == z4.getB()) {
            return true;
        }
        return false;
    }

    Fraction neg(){
        return new Fraction(-this.a, this.b);
    }

    Fraction pow(int n){
        return new Fraction((int)Math.pow(this.a, n), (int)Math.pow(this.b, n));
    }

    static Fraction parse(String str){
        String tokens[] = str.split(" / ");
        int a = Integer.parseInt(tokens[0]);
        int b = Integer.parseInt(tokens[1]);
        return new Fraction(a, b);
    }


    @java.lang.Override
    public java.lang.String toString() {
        return this.a + " / " + this.b;
    }


    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public int compareTo(Fraction fraction) {
        int n1 = this.a * fraction.b;
        int n2 = fraction.a * this.b;
        if (fraction.b < 0){
            n1 *= -1;
            n2 *= -1;
        }
        if (this.b < 0){
            n1 *= -1;
            n2 *= -1;
        }
        if (n1 < n2){
            return -1;
        }
        else if (n1 > n2){
            return 1;
        }
        else{
            return 0;
        }
    }
}