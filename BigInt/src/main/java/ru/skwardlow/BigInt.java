package ru.skwardlow;

import java.math.BigInteger;

public class BigInt {
    public static void main(String[] args) {
        BigInteger soBIG;
        soBIG= BigInteger.valueOf(2);
        soBIG = soBIG.pow(10000);
        System.out.print("Exponentating 2 in 10000 is ");
        System.out.println(soBIG.toString());
    }
}
