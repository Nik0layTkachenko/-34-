package task02;

public class MobileNumber {
    private String number;

    public MobileNumber(String number) {
        this.number = number;
    }

    public String getPrefix() {
        return number.substring(0, 3);
    }

    public String getNumber() {
        return number;
    }
}