package task02;

import java.util.ArrayList;
import java.util.List;

public class MobileOperatorDetector {
    private List<MobileOperator> operators;

    public MobileOperatorDetector() {
        operators = new ArrayList<>();
        operators.add(new MobileOperator("Kyivstar", "UA", "067", "Kyivstar"));
        operators.add(new MobileOperator("Vodafone", "UA", "050", "Vodafone"));
           operators.add(new MobileOperator("Vodafone", "UA", "099", "Vodafone"));
        operators.add(new MobileOperator("lifecell", "UA", "063", "lifecell"));
        // add more operators here
    }

    public MobileOperator detectMobileOperator(MobileNumber number) {
        for (MobileOperator operator : operators) {
            if (operator.getPrefix().equals(number.getPrefix())) {
                return operator;
            }
        }
        return null;
    }
}
