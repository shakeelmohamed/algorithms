package com.shakeel.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class BraceValidator {

    public static boolean isValid(String input) {
        Map braces = new HashMap<Character, Character>();
        braces.put('{', '}');
        braces.put('[', ']');
        braces.put('(', ')');

        Stack<Character> openers = new Stack<Character>();
        char[] chars = input.toCharArray();

        for (char c : chars) {
            if (braces.keySet().contains(c)) {
                openers.push(c);
            } else if (braces.values().contains(c)) {
                if (openers.isEmpty())
                    return false;
                else if (c != braces.get(openers.peek()))
                    return false;
                else
                    openers.pop();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Print true for passing tests

        String test1 = "{}";
        System.out.println(isValid(test1));

        String test2 = "{}[]()[({})]";
        System.out.println(isValid(test2));

        String test3 = "{{{]]]";
        System.out.println(!isValid(test3));
    }
}
