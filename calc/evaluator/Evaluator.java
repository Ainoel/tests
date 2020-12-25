package evaluator;

public class Evaluator {
    private static int pos;
    private static char c;
    private static String str;

    private static void nextChar() {
        pos++;
        if (pos < str.length()) {
            c = str.charAt(pos);
        } else {
            c = '?';
        }
    }

    private static boolean eat(char ch) {
        while (c == ' ') nextChar();
        if (c == ch) {
            nextChar();
            return true;
        }
        return false;
    }

    public static double eval(String s) {
        str = s;
        pos = -1;
        nextChar();
        double x = parseB();
        if (pos < str.length()) {
            throw new ArithmeticException("Нераспознанный символ: " + c);
        }
        return x;
    }

    private static double parseB() {
        double v = parseC();
        while (true) {
            if (eat('+')) v += parseC();
            else if (eat('-')) v -= parseC();
            else return v;
        }
    }

    private static double parseC() {
        double v = parseD();
        while (true) {
            if (eat('*')) v *= parseD();
            else if (eat('/')) v /= parseD();
            else return v;
        }
    }

    private static double parseD() {
        if (eat('+')) return parseD();
        if (eat('-')) return -parseD();

        double v;
        int startPos = pos;
        if (eat('(')) {
            v = parseB();
            eat(')');
        } else if (Character.isDigit(c) || c == '.') {
            do {
                nextChar();
            } while (Character.isDigit(c) || c == '.');
            v = Double.parseDouble(str.substring(startPos, pos));
        } else {
            throw new RuntimeException("Нераспознанный символ: " + c);
        }

        if (eat('^')) {
            v = Math.pow(v, parseD());
        }

        return v;
    }
}
