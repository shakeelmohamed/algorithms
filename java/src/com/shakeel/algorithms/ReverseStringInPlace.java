package com.shakeel.algorithms;

public class ReverseStringInPlace {
    public static String reverse(String input) {
        if (input.length() <= 1)
            return input;
        int front = 0;
        int back = input.length() - 1;

        char[] chars = input.toCharArray();
        // Skip case when front == back, only happens for odd-length strings... mid char doesn't need to move
        while (front < back) {
            char temp = chars[front];
            chars[front] = chars[back];
            chars[back] = temp;
            front++;
            back--;
        }

        return new String(chars);
    }
    public static void main(String[] args) {
        // Print true for passing tests

        String test1 = "abc";
        System.out.println("cba".equals(reverse(test1)));

        String test2 = "aoseifhwaoefhwoefihweofabsdvcbasvbvbbsbszosuibef83012u3hfa";
        System.out.println("afh3u21038febiusozsbsbbvbvsabcvdsbafoewhifeowhfeoawhfiesoa".equals(reverse(test2)));
    }
}
