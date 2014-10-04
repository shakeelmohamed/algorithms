class ReverseStringInPlace {
    String rev(String input) {
        if (input.length() <= 1)
            return input;
        int front = 0;
        int back = input.length() - 1;

        // Skip case when front == back, only happens for odd-length strings... mid char doesn't need to move
        while (front < back) {
            char temp = input.charAt(front);
            input.setCharAt(front, input.charAt(back));
            input.setCharAt(back, temp);
            front++;
            back--;
        }
        return input;
    }
}
