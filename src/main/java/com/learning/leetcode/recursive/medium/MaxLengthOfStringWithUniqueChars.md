## Problem statement

- Given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters. Return the maximum possible length of s.
- A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
```
Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All the valid concatenations are:
- ""
- "un"
- "iq"
- "ue"
- "uniq" ("un" + "iq")
- "ique" ("iq" + "ue")
  Maximum length is 4.
```
```
Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
```
```
Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26
Explanation: The only string in arr has all 26 characters.
```
```
Constraints:

1 <= arr.length <= 16
1 <= arr[i].length <= 26
arr[i] contains only lowercase English letters.
```

## Solution
```java
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
```