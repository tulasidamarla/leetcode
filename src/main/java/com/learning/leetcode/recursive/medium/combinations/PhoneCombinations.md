## Problem statement
- Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
- A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

![Telephone Keypad](./telephone_keypad.png)

```
Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
```
```
Example 2:

Input: digits = ""
Output: []
```
```
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
```
```
Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
```

## Solution
```java
import java.util.*;

public class PhoneCombinations {
    public static void main(String[] args) {
        Map<Character, String> map = new HashMap<>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");

        }};
        System.out.println(map);
        List<String> result = new ArrayList<>();
        System.out.println("Combinations for 23 are");
        phoneCombinations(0, "23", "", map, result);
        System.out.println(result);
        result.clear();
        System.out.println("Combinations for 357 are");
        phoneCombinations(0, "357", "", map, result);
        System.out.println(result);

    }

    private static void phoneCombinations(int i, 
                                  String digits, 
                                  String temp, 
                                  Map<Character, String> map, 
                                  List<String> result) {
        if (i == digits.length()) {
            result.add(temp);
            return;
        }
        String chars = map.get(digits.charAt(i));
        for (int j = 0; j < chars.length(); j++) {
            temp = temp + chars.charAt(j);
            phoneCombinations(i + 1, digits, temp, map, result);
            temp = temp.substring(0, temp.length() - 1);
        }
    }
}

```