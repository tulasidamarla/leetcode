package com.learning.leetcode.recursive;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringJoinTest {
    public static void main(String[] args) {
        List<String> chars = new ArrayList<>(){{
            add("L");
            add("D");
        }};
        System.out.println(String.join("", chars));
        //String.join("", chars.);
        //chars.stream().collect(Collectors.joining())

    }
}
