package com.spezdmtest.javacore.chapter18.Exercise2;

public class AnalyserBracketsDemo {
    public static void main(String[] args) {
        System.out.println(AnalyzerBrackets.analyzerBrackets("[({})]"));
        System.out.println(AnalyzerBrackets.analyzerBrackets("[(){}"));
    }
}