package com.interview.questions.lloyds.tech;
import java.util.HashSet;
import java.util.Set;

public class UniqueLines {

    public static int countUniqueLines(int[][] friendsHomes) {
        Set<Double> uniqueLines = new HashSet<>();
        for(int i= 1; i < friendsHomes.length; i++){
            int x = friendsHomes[i][0];
            int y = friendsHomes[i][1];
            uniqueLines.add((double)x/(double)y);
        }
        System.out.println(uniqueLines);
        return uniqueLines.size();

        //3



//        6 2
//
//        2 2
//        3 3
//                -4 -8
//        8 8
//                -1 -1
//        5 8
//        0
//        0

//        o/p:
//
//        3

    }



    public static void main(String[] args) {
        int[][] friendsHomes = {{3, 2}, {1, 1}, {-1, 1}, {2,3}};

        int uniqueLines = countUniqueLines(friendsHomes);
        System.out.println("uniquelines ===========" + uniqueLines); // 3
        friendsHomes = new int[][]{{6,2},{2,2},{3,3},{-4,-8},{8,8},{-1,-1},{5,8}};
        int uniqueLines2 = countUniqueLines(friendsHomes);
        System.out.println("uniquelines ===========" + uniqueLines2); // 3

    }
}