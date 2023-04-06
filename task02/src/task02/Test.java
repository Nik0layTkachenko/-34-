package task02;

public class Test {

        public static void main(String args[]) {
    MobileNumber number = new MobileNumber("0991900099");
    MobileOperatorDetector detector = new MobileOperatorDetector();
    MobileOperator operator = detector.detectMobileOperator(number);
if (operator != null) {
    System.out.println("Mobile operator: " + operator.getName());
} else {
    System.out.println("Mobile operator not found");
}

    }
}
