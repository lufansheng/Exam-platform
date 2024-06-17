package com.java.utils;

import java.util.Arrays;
import java.util.List;


public class equal {

    public static int equalityOfArrays(String[] answers, String[] conditionAnswer) {
        if (conditionAnswer == null || answers == null){
            System.out.println("为null");
            return 0;
        }
        List<String> list = Arrays.asList(conditionAnswer);
        if (answers.length != conditionAnswer.length) {
            //单独判断,看一下是拿一半还是拿满分
            for (String answer : answers) {
                if (!list.contains(answer))
                    System.out.println("匹配补上");
                    return 0;
            }
        }
        Arrays.sort(answers);
        Arrays.sort(conditionAnswer);
        if (Arrays.equals(answers,conditionAnswer))
            return 2;
        System.out.println("匹配上了");
        return 1;
    }
}


