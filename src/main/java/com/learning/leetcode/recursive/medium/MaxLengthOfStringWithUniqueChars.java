package com.learning.leetcode.recursive.medium;

import java.util.List;

public class MaxLengthOfStringWithUniqueChars {
    public static void main(String[] args) {
        int[] pickedList = new int[26];
        //System.out.println(pickedList[pickedList.length-1]);

        System.out.println(getMaxLength(0,List.of("un","iq","ue"), pickedList, 0));
        System.out.println(getMaxLength(0,List.of("cha","r","act","ers"), pickedList, 0));
    }

    private static int getMaxLength(int index, List<String> strings, int[] pickedList, int lengthSoFar){

        if (index == strings.size()){
            return lengthSoFar;
        }
        String currString = strings.get(index);


        if (!compare(pickedList, currString)){
            return getMaxLength(index+1, strings, pickedList, lengthSoFar);
        } else {
            //pick
            for(int j=0; j < currString.length(); j++){
                pickedList[(int)currString.charAt(j) - ((int)'a')] = 1;
            }
            lengthSoFar += currString.length();
            int op1 = getMaxLength(index+1, strings, pickedList, lengthSoFar);

            //skip
            for(int j=0; j < currString.length(); j++){
                pickedList[(int)currString.charAt(j) - ((int)'a')] = 0;
            }
            lengthSoFar -= currString.length();
            int op2 = getMaxLength(index+1, strings, pickedList, lengthSoFar);

            return Math.max(op1, op2);
        }


    }

    private static boolean compare(int[] pickedList, String currString){
        int[] selfCheck = new int[26];
        for(int i=0; i< currString.length(); i++){
            if (selfCheck[(int)currString.charAt(i) - ((int)'a')] == 1){
                return false;
            }
            selfCheck[(int)currString.charAt(i) - ((int)'a')] = 1;
        }
        for(int i=0; i < currString.length(); i++){
            if(pickedList[(int)currString.charAt(i) - ((int)'a')] == 1){
                return false;
            }
        }
        return true;
    }
}
