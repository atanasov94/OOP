package telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            boolean isValid = true;
            for (char c : url.toCharArray()) {
                if (Character.isDigit(c)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                sb.append("Browsing: ");
                sb.append(url);
                sb.append("!");
                sb.append(System.lineSeparator());
            } else {
                sb.append("Invalid URL!");
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            boolean isValid = true;
            for (char c : number.toCharArray()) {
                if (Character.isAlphabetic(c)) {
                    isValid = false;
                }
            }
            if (isValid) {
                sb.append("Calling... ");
                sb.append(number);
                sb.append(System.lineSeparator());
            } else {
                sb.append("Invalid number!");
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
