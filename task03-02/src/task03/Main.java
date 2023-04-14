package task02;

public class Main {
    private static MobileOperatorDetector detector = new MobileOperatorDetector();
    private static View view = new View(detector);

    public static void main(String[] args) {
        view.start();
    }
}