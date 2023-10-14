package model;

import java.util.ArrayList;

public class PhoneNumbers {
    ArrayList<String> numbers;

    public PhoneNumbers() {
        numbers = new ArrayList<>();
    }

    public ArrayList<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<String> numbers) {
        this.numbers = numbers;
    }
    public void addNumber(String number) {
        numbers.add(number);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(String n : numbers) {
            sb.append(n).append(", ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
