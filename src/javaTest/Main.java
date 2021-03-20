package javaTest;

/**
 * @Author: 11655
 * @Date: 2021/3/8 22:37
 * @Description:
 */
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final List a;
        String aa="";
//        StringBuilder;

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();

            System.out.println(getValue(line, line.length() - 1, 0));
        }
    }

    public static int getExactvalue(char temp) {
        if (temp <= '9' && temp >= '0')
            return temp - '0';
        if (temp <= 'F' && temp >= 'A')
            return temp - 'A'+10;
        return 0;
    }

    public static int getValue(String hex, int index, int base) {
        if (index < 2) return 0;
        else {
            int bei = (int) Math.pow(16, base);
            return getExactvalue(hex.charAt(index)) * bei + getValue(hex, index - 1, ++base);
        }
    }
}

