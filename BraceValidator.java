class BraceValidator {
    int indexOf(Array ar, Char c) {
        for (int i = 0; i < ar.length() ; i++) {
            if (ar[i] == c) {
                return i;
            }
        }
        return -1;
    }
    boolean isValid(String input) {
        Map braces = new Map<char, char>();
        braces.put('{', '}');
        braces.put('[', ']');
        braces.put('(', ')');

        Stack<char> openers = new Stack<char>();
        char[] chars = input.toCharArray();
        for (Char c : chars) {
            if (braces.keySet().contains(c)) {
                openers.push(c);
            }
            else if (braces.values().contains(c)) {
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
}
