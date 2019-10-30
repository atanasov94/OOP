package rhombus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int size = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= size; i++) {
            System.out.print(printSpaces(size-i));
            System.out.println(printRow(i));
        }

        for (int i = 1; i <= size-1; i++) {
            System.out.print(printSpaces(i));
            System.out.println(printRow(size-i));
        }

    }

    private static String printRow(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("* ");
        }
        return sb.toString().trim();
    }

    private static String printSpaces(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}