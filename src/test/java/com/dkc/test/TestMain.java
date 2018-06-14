package com.dkc.test;

public class TestMain
{
    public static void main(String... args) 
    {
        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b;
        System.out.println("40 + 2 = " +
            operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " +
            operateBinary(20, 10, subtraction));    
    }
	
	static void changeString(String s) { s= "b"; }
	
    interface IntegerMath {
        int operation(int a, int b);   
    }
    
    public static int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }
 
    
    IntegerMath addition = (a, b) -> a + b;
}