package task02;

import java.util.Scanner;

public class View {
    private MobileOperatorDetector detector;

    public View(MobileOperatorDetector detector) {
        this.detector = detector;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter mobile number:");
            String numberString = scanner.nextLine();
            if (numberString.equalsIgnoreCase("exit")) {
                break;
            }

            MobileNumber number = new MobileNumber(numberString);
            MobileOperator operator = detector.detectMobileOperator(number);

            if (operator != null) {
                System.out.println("Mobile operator: " + operator.getName());
            } else {
                System.out.println("Mobile operator not found");
            }
        }
    }
}